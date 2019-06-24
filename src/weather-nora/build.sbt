name := "Weather Nora"

version := "0.1"

scalaVersion := "2.12.8"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "io.spray" %% "spray-json" % "1.3.5",
  "com.typesafe.akka" %% "akka-http" % "10.1.8",
  "com.typesafe.akka" %% "akka-stream" % "2.5.23",
  "com.typesafe.akka" %% "akka-http-core" % "10.1.8",
  "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test,
  "com.typesafe.akka" %% "akka-http-core" % "10.1.8",
  "org.scalaj" %% "scalaj-http" % "2.4.1",
  "net.virtual-void" %%  "json-lenses" % "0.6.2",
  "com.github.daddykotex" %% "courier" % "1.0.0"
  )
