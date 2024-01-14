import sbt._

object Dependencies {
  val akkaVersion = "2.6.20"
  val akkaHttpVersion = "10.2.6"

  val cornichonVersion = "0.20.8"

  lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val typesafeConfig = "com.typesafe" % "config" % "1.4.3"
  lazy val cornichon = "com.github.agourlay" %% "cornichon-scalatest" % cornichonVersion % Test
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.4.14"
  lazy val akkaSlf7j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
}
