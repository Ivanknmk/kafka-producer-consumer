libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.10" % "0.8.1"
      exclude("javax.jms", "jms")
      exclude("com.sun.jdmk", "jmxtools")
      exclude("com.sun.jmx", "jmxri"),
      "com.typesafe" % "config" % "1.2.1",
      "com.typesafe.play" % "play-json_2.10" % "2.4.0-M2",
      "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test",
      "org.twitter4j" % "twitter4j-core" % "4.0.2",
      "org.twitter4j" % "twitter4j-stream" % "4.0.2",
        "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
        "org.slf4j" % "slf4j-api" % "1.7.1",
        "org.slf4j" % "log4j-over-slf4j" % "1.7.1",  // for any java classes looking for this
        "ch.qos.logback" % "logback-classic" % "1.0.3"
)