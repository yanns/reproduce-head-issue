import sbt._

object Dependencies {

  val akkaHttpVersion = "10.2.6"

  val cornichonVersion = "0.20.8"

  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val cornichon = "com.github.agourlay" %% "cornichon-scalatest" % cornichonVersion

}
