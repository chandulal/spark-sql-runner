package com.example

import java.io.File

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}


object SparkStreamRunner {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
//      .master("local")
      .appName("File_Streaming")
      .enableHiveSupport()
      .getOrCreate()

    val schema = StructType(
      Array(StructField("id", StringType),
        StructField("pid", StringType),
        StructField("pname", StringType),
        StructField("date", StringType)))

    //stream the orders from the csv files.
    val ordersStreamDF = spark
      .readStream
      .option("header", "true")
      .schema(schema)
      .csv(args(0))

    val query = ordersStreamDF
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
    query.awaitTermination()
  }
}
