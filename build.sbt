name := "refreshRandom"

version := "0.1"

scalaVersion := "2.13.6"

val zioVersion = "1.0.12"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-streams" % zioVersion,

  "org.scalatest" %% "scalatest" % "3.2.9",

  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
)

Test / parallelExecution := false

// for running directly from terminal
unmanagedSourceDirectories in Test := baseDirectory { base =>
  Seq(
    // base / "src/test/scala",
    // base / "src/main/scala/random"
  )
}.value

// sbt "testOnly random.CurrencyIntTest"
