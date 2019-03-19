name := "spark-sample"

version := "0.1"


scalaVersion := "2.11.8"

val sparkVersion = "2.3.0"

lazy val root = (project in file(".")).
//  settings(commonSettings: _*).
  settings(
  inThisBuild(List(
    scalaVersion := "2.11.8",
    version := "0.1",
    mainClass in Compile := Some("com.example.SpakSQLRunner")
  )),
  name := "spark-sample",
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
    "org.apache.spark" %% "spark-hive" % sparkVersion % "provided"
  )
)

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)
