package cs2.adt

class DoubleLinkedSeq[A : Manifest] extends Seq[A] {
  private class Node(var data:A, var prev:Node, var next:Node)
  private var sent:Node = new Node (Array.ofDim[A](1).apply(0), null, null)
  sent.prev = sent
  sent.next = sent

  private var len:Int = 0
  
  private def getNode(idx:Int):Node = {
    var rover = hed
    for(ctr <- 0 until idx) {
      rover = rover.next
    }
    rover
  }

  def get(idx:Int):A = {
    if(idx < 0 || idx >= length()) throw new IndexOutOfBoundsException()
    getNode(idx).data
  }
  def set(idx:Int, elem:A):Unit = {
    getNode(idx).data = elem
  }
  def insert(idx:Int, elem:A):Unit = {
    len += 1
    val bef = getNode(idx - 1)
    bef.next = new Node(elem, bef, bef.next)
    bef.next.next.prev = bef.next
  }
  def remove(idx:Int):Unit = {
    len -= 1
    val rover = getNode(idx)
    rover.prev.next = rover.next
    rover.next.prev = rover.prev
  }

  def length():Int = len
  def iterator:Iterator[A] = ???
}