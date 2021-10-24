import Dependencies._

ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "distributed",
    libraryDependencies ++= Seq(scalaTest % Test, jsonSpray, openCsv) ++ akka.list
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
