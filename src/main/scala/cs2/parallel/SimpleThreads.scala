package cs2.parallel

import io.StdIn._
object SimpleThreads {
  def countDownGetName():Unit = {
    val thread = new Thread {
      override def run():Unit = {
        //Thread to count
        for(i <- 1 to 5) {
          println(i)
          Thread.sleep(1000)
        }
        println("Times up Jerk!")
        sys.exit(0)
      }
    }
    thread.start

    //Thread to get user's name
    println("Enter your name:")
    val name = readLine()
    thread.stop
    println("Hello, " + name)
  }

  class Lock
  val lock = new Lock

  def countToABillion():Unit = {
    var ctr = 0
    val nThreads = 10
    val threads = Array.fill(nThreads)(new Thread {
      override def run():Unit = {
        for(i <- 1 to 1000000000/nThreads) {
          lock.synchronized {
            ctr += 1
          }
        }
      }
    })
    for(t <- threads) { t.start }
    for(t <- threads) { t.join }
    
    println(ctr)
  }
  def main(args:Array[String]):Unit = {
    //countDownGetName()
    countToABillion()
  }
}