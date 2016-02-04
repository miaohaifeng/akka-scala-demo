name := "akka-scala-demo"

version := "1.0"

scalaVersion := "2.10.5"
val AKKA_VERSION = "2.2.5"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)
libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.10" % AKKA_VERSION,
  "com.typesafe.akka" %% "akka-remote" % AKKA_VERSION,
  "com.typesafe.akka" %% "akka-contrib" % AKKA_VERSION,
  "com.typesafe.akka" % "akka-camel_2.10" % AKKA_VERSION exclude("org.apache.camel", "camel-jms")
)
    