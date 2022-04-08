package cs2.adt

class LinkedSeq[A] extends Seq[A] {
  private class Node (var data:A, var next:Node)
  private var hed:Node = null
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
    if(idx == 0) {
      hed = new Node(elem, hed)
    } else {
      val oneBefore = getNode(idx - 1)
      oneBefore.next = new Node(elem, oneBefore.next)
    }
  }
  def remove(idx:Int):Unit = {
    len -= 1
    if(idx == 0) {
      hed = hed.next
    } else {
      val oneBefore = getNode(idx - 1)
      oneBefore.next = oneBefore.next.next
    }
  }
  def length():Int = len

  def iterator:Iterator[A] = {
    new Iterator[A] {
      var current:Node = hed

      def next():A = {
        val ret = current.data
        current = current.next
        ret
      }
      def hasNext:Boolean = {
        current != null
      }
    }
  }
}


