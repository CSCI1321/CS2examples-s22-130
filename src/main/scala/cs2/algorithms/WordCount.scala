package cs2.algorithms

import scala.io.Source

object WordCount {

  def main(args:Array[String]):Unit = {

    val path = getClass().getResource("/tempest.txt")
    val lines = Source.fromURL(path).getLines()

    /*
    val wordSet = scala.collection.mutable.Set[String]()
    for(line <- lines) {
      val words = line.split("\\s+").map(_.filter(_.isLetter).toLowerCase())
      wordSet ++= words
    }
    for(word <- wordSet) println(word)
    println(wordSet.size)
    */

    val countMap = scala.collection.mutable.Map[String,Int]()
    for(line <- lines) {
      val words = line.split("\\s+").map(_.filter(_.isLetter).toLowerCase())
      for(word <- words) {
        if(countMap.contains(word)) countMap(word) += 1
        else countMap(word) = 1
      }
    }
    countMap -= ""

    var bigKey:String = countMap.keys.toArray.apply(0)
    for(tup <- countMap) {
      if(tup._2 > countMap(bigKey)) bigKey = tup._1
    }
    println(bigKey + " --> " + countMap(bigKey))

    val arr = countMap.toArray
    ParametricSorting.bubbleSort(arr, (x:(String,Int), y:(String,Int)) => x._2 > y._2)
    println(arr.mkString("\n"))

  }


}