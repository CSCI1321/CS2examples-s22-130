package cs2.algorithms

import scala.io.Source

object WordCount {

  def main(args:Array[String]):Unit = {

    val path = getClass().getResource("/tempest.txt")
    val lines = Source.fromURL(path).getLines()

    val wordSet = scala.collection.mutable.Set[String]()

    for(line <- lines) {
      val words = line.split("\\s+").map(_.filter(_.isLetter).toLowerCase())
      wordSet ++= words
    }
    for(word <- wordSet) println(word)
    println(wordSet.size)

  }


}