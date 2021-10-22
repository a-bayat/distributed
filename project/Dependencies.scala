import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.8"
  lazy val slick = "com.typesafe.slick" %% "slick" % "3.3.3"
  lazy val slickHikaricp = "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"
  lazy val sqliteDriver= "org.xerial" % "sqlite-jdbc" % "3.36.0.3"
  lazy val jsonSpray = "com.softwaremill.sttp.tapir" %% "tapir-json-spray" % "0.18.3"


  lazy val akka = new {
    lazy val version = "2.6.15"
    lazy val httpVersion = "10.2.6"
    lazy val group = "com.typesafe.akka"

    lazy val actor = group %% "akka-actor-typed" % version
    lazy val http = group %% "akka-http" % httpVersion

    lazy val test = Seq(
      group %% "akka-actor-testkit-typed" % version % Test,
      group %% "akka-stream-testkit" % version % Test,
      group %% "akka-http-testkit" % httpVersion % Test
    )

    lazy val list = List(actor, http) ++ test
  }

}
