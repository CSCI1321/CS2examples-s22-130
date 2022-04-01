package cs2.adt

import org.junit._
import org.junit.Assert._

class StackTester {
  var s:Stack[Int] = null

  @Before def init():Unit = {
    s = Stack[Int]()
  }

  @Test def checkEmptyStackException():Unit = {
    try {
      s.pop()
      assertTrue(false)
    } catch {
      case ex:java.util.EmptyStackException => { }
    }
    try {
      s.push(1)
      s.pop()
    } catch {
      case ex:java.util.EmptyStackException => {
        assertTrue(false)
      }
    }
  }

  @Test def checkIsEmptyInitially():Unit = {
    assertTrue(s.isEmpty())
  }

  @Test def checkNotEmptyAfterPush():Unit = {
    s.push(1)
    assertTrue(!s.isEmpty())
  }

  @Test def checkManyPushPops():Unit = {
    for(i <- 1 to 50) {
      s.push(i)
    }
    assertTrue(!s.isEmpty())
    for(i <- 50 to 1 by -1) {
      assertTrue(s.peek == i)
      assertTrue(s.pop == i)
    }
    assertTrue(s.isEmpty())
  }


}


