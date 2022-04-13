package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private class Node (var data:A, var next:Node)
  private var head:Node = null

  def add(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def get():A = ???
  def peek():A = {
    var biggest = head.data
    var current = head.next
    while(current != null) {
      if(current.data > biggest) biggest = current.data
      current = current.next
    }
    biggest
  }
  def isEmpty():Boolean = { head == null }
}

