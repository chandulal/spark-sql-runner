package com.example

import org.apache.spark._
import org.apache.spark.sql.SparkSession

object SparkSQLRunner {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.sql.orc.filterPushdown", "true")
      .config("spark.sql.orc.splits.include.file.footer", "true")
      .config("spark.sql.orc.cache.stripe.details.size", 10000)
      .config("spark.sql.hive.metastorePartitionPruning", "true")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    spark.sql(
      args(0)
    ).show()
  }
}