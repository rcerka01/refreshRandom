name := "refreshRandom"

version := "0.1"

scalaVersion := "2.13.6"

val zioVersion = "1.0.12"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-streams" % zioVersion
)
