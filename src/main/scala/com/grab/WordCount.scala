package com.grab

import org.apache.spark._
import org.apache.spark.SparkContext._

object WordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    val sc = new SparkContext(conf)

    val input = sc.parallelize(List("hello", "world", "hi", "hello", "world", "hello"))

    val words = input.flatMap(line => line.split(" "))
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    counts.collect().foreach(println(_))
  }
}