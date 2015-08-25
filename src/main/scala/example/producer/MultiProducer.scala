package example.producer

import akka.actor.{ActorRef, Actor, ActorSystem, Props}

class KafkaActor extends Actor {

  val topicName = "testTopic"
  val strProducer = Producer[String](topicName)

  def receive = {
    case s:String => strProducer.send(s)
    case i:Int => for (x <- 1 until i ) strProducer.send(i.toString)
    case _       => println("huh?")
  }
}

object MultiProducer{
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("KafkaMessages")

    println("How many actors?")
    val actors : Int = readInt()

    println("How many messages per actor?")
    val messages : Int = readInt()

    /*
    println("What would be the top size of each message (in mb)?")
    val size = io.Source.stdin.reader
    */

    for ( x <- 0 until actors ) {
      val kafkaActor = system.actorOf(Props[KafkaActor], name = "kafka_actor" ++ x.toString)
      kafkaActor ! messages
    }
  }

}
