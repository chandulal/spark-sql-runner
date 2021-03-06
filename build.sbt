name := "spark-sample"

version := "0.1"


scalaVersion := "2.12.8"

val sparkVersion = "2.4.4"

lazy val root = (project in file(".")).
//  settings(commonSettings: _*).
  settings(
  inThisBuild(List(
    scalaVersion := "2.11.8",
    version := "0.1",
    mainClass in Compile := Some("com.example.SparkStreamRunner")
  )),
  name := "spark-sample",
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-catalyst" % sparkVersion % "provided"
  )
)

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)
