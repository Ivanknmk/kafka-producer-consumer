package example.producer

import scala.util.Random

object ProducerStreamExample {
  def main(args: Array[String]): Unit = {
    val strProducer = Producer[String]("testTopic")

    println("How many messages in the stream?")
    val messages : Int = readInt()

    println("length of the string?")
    val charNum : Int = readInt()

    val messageStream = Stream.continually{
      Random.alphanumeric.take(charNum).mkString
    }.take(messages)

    strProducer.sendStream(messageStream)
  }
}
