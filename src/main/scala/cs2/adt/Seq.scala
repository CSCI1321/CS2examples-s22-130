package cs2.adt

abstract class Seq[A] extends Iterable[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A):Unit
  def insert(idx:Int, elem:A):Unit
  def remove(idx:Int):Unit
  def length():Int
  def iterator:Iterator[A]

  def prepend(elem:A):Unit = insert(0, elem)
  def +:= (elem:A):Unit = prepend(elem)
  def append(elem:A):Unit = insert(length(), elem)
  def += (elem:A):Unit = append(elem)

  def apply(idx:Int):A = get(idx)
  def update(idx:Int, elem:A):Unit = set(idx, elem)
}

object Seq {
  def apply[A]():Seq[A] = {
    new LinkedSeq[A]()
  }

  def main(args:Array[String]):Unit = {
    val s = Seq[Char]()
    //Add stuff to s
    s.insert(0,'A')
    s.insert(0,'B')
    s.insert(0,'C')
    s.insert(0,'D')

    for(i <- 0 until s.length()) {
      println(s.get(i))
    }

    var it = s.iterator
    while(it.hasNext) {
      println(it.next)
    }

    it = s.iterator
    it.foreach(println)

    for(x <- s) println(x)
    println(s.mkString(","))
    println(s.map(_+"Hello").mkString(","))

  }

}

