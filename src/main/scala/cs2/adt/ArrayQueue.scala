package cs2.adt

class ArrayQueue[A:Manifest] extends Queue[A] {
  var arr:Array[A] = Array.ofDim[A](10)
  var len = 0
  var beg = 0

  def enqueue(elem:A):Unit = {
    arr((beg + len) % arr.length) = elem
    len += 1
  }
  def dequeue():A = {
    val ret = arr(beg)
    beg = (beg + 1) % arr.length
    len -= 1
    ret
  }
  def peek():A = { arr(beg) }
  def isEmpty():Boolean = { len == 0 }
}