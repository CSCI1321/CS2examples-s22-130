package cs2.adt

abstract class Seq[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A):Unit
  def insert(idx:Int, elem:A):Unit
  def remove(idx:Int):Unit
  def length():Int
}

object Seq {
  def apply[A]():Seq[A] = {
    new LinkedSeq[A]()
  }

  def main(args:Array[String]):Unit = {
    val s = Seq[Char]()
    //Add stuff to s
    for(i <- 0 until s.length()) {
      println(s.get(i))
    }
  }

}

