name := "Weather Nora"

version := "0.1"

scalaVersion := "2.12.7"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.4"
libraryDependencies += "io.spray" %% "spray-json" % "1.3.5"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.8"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.23"
libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "10.1.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "10.1.8"
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.1"
