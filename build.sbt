name := "spark-sample"

version := "0.1"


scalaVersion := "2.11.8"

val sparkVersion = "2.3.0"



//lazy val commonSettings: Seq[Setting[_]] = Seq(
//  version in ThisBuild := "0.14.9-SNAPSHOT",
//  organization in ThisBuild := "com.eed3si9n"
//)

lazy val root = (project in file(".")).
//  settings(commonSettings: _*).
  settings(
    sbtPlugin := true,
    name := "sbt-assembly",
    description := "sbt plugin to create a single fat jar",
    scalacOptions := Seq("-deprecation", "-unchecked", "-Dscalac.patmat.analysisBudget=1024", "-Xfuture"),
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-sql" % sparkVersion
    ),
    publishArtifact in (Compile, packageBin) := true,
    publishArtifact in (Test, packageBin) := false,
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in (Compile, packageSrc) := true
  )

resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

mainClass in Compile := Some("com.grab.WordCount")