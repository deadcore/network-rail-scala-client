name := "network-rail-client"

version := "0.0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-native" % "3.5.0",
  "com.hi3project.vineyard.comm" % "gozirra-ws" % "0.5.0",
  "org.apache.httpcomponents" % "httpclient" % "4.5.3",
  "io.reactivex.rxjava2" % "rxjava" % "2.1.6",
  "org.apache.activemq" % "activemq-client" % "5.15.2",
  "org.projectodd.stilts" % "stilts-stomp-client" % "0.1.40" % "test",
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.mockito" % "mockito-all" % "1.10.19" % Test,
  "org.scalatest" % "scalatest_2.12" % "3.0.1" % Test
).map(_
  .exclude("org.slf4j", "slf4j-jdk14")
  .exclude("org.slf4j", "slf4j-nop")
) ++ Seq(
  "ch.qos.logback" % "logback-core" % "1.2.1",
  "ch.qos.logback" % "logback-classic" % "1.2.1"
)