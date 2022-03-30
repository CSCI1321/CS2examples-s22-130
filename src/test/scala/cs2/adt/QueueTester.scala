package cs2.adt

import org.junit._
import org.junit.Assert._

class QueueTester {
  var q:Queue[Int] = null

  @Before def init():Unit = {
    q = Queue[Int]()
  }

  @Test def testIsEmpty():Unit = {
    assertTrue(q.isEmpty())
    q.enqueue(1)
    assertFalse(q.isEmpty())
    q.peek()
    assertFalse(q.isEmpty())
    q.dequeue()
    assertTrue(q.isEmpty())
  }

  @Test def testEnqueueDequeuePeek():Unit = {
    q.enqueue(1)
    assertTrue(q.peek() == 1)
    assertTrue(q.dequeue() == 1)
    for(iter <- 1 to 2) {
      for(x <- 50 to 200) {
        q.enqueue(x)
      }
      for(x <- 50 to 100) {
        assertTrue(q.peek() == x)
        assertTrue(q.dequeue() == x)
      }
      for(x <- 1 to 20) {
        q.enqueue(x)
      }
      for(x <- 101 to 200) {
        assertTrue(q.peek() == x)
        assertTrue(q.dequeue() == x)
      }
      for(x <- 1 to 20) {
        assertTrue(q.peek() == x)
        assertTrue(q.dequeue() == x)
      }
    }
  }

}

