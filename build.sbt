import Dependencies._

Global / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .aggregate(httpServer, featureTests)


lazy val httpServer = (project in file("apps/http-server"))
  .settings(
    name := "http-server",
    libraryDependencies ++= List(akkaHttp, akkaStream, typesafeConfig, logback, akkaSlf7j),
  )

lazy val featureTests = (project in file("feature-tests"))
  .settings(
    name := "feature-tests",
    libraryDependencies += cornichon,
    testFrameworks += new TestFramework("com.github.agourlay.cornichon.framework.CornichonFramework")
  )
