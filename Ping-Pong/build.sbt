ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "Ping-Pong"
  )
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.8.4",
  "ch.qos.logback" % "logback-classic" % "1.5.8"
)
