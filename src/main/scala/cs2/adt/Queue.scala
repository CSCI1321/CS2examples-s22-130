package cs2.adt

abstract class Queue[A] {
  def enqueue(elem:A):Unit
  def dequeue():A
  def peek():A
  def isEmpty():Boolean
}

class EmptyQueueException extends Exception("Empty Queue")

object Queue {
  def apply[A:Manifest]():Queue[A] = {
    new LinkedQueue[A]()
  }
}

