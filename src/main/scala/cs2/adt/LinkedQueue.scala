package cs2.adt

class LinkedQueue[A] extends Queue[A] {
  private class Node (val data:A, var next:Node)
  private var head:Node = null
  private var last:Node = null

  def enqueue(elem:A):Unit = {
    if(last == null) {
      last = new Node(elem, null)
      head = last
    } else {
      last.next = new Node(elem, null)
      last = last.next
    }
  }
  def dequeue():A = {
    if(isEmpty()) throw new EmptyQueueException()
    val ret = head.data
    if(head == last) {
      head = null
      last = null
    } else {    
      head = head.next
    }
    ret
  }
  def peek():A = {
    if(isEmpty()) throw new EmptyQueueException()
    head.data
  }
  def isEmpty():Boolean = { head == null }
}