package cs2.adt

class BinarySearchTree[A <% Ordered[A]] extends Iterable[A] {
  private class Node(var data:A, var left:Node, var right:Node) {
    def contain(elem:A):Boolean = {
      if(data >= elem && data <= elem) true //data.compareTo(elem) == 0
      else {
        if(elem > data) {
          if(right == null) false else right.contain(elem)
        } else {
          if(left == null) false else left.contain(elem)
        }
      }
    }
    def insert(elem:A):Unit = {
      if(elem > data) {
        if(right == null) right = new Node(elem, null, null)
        else right.insert(elem)
      }
      else {
        if(left == null) left = new Node(elem, null, null)
        else left.insert(elem)
      }
    }
    def passUpMax():(Node, A) = {
      if(right != null) {
        val (n,v) = right.passUpMax()
        right = n
        (this, v)
      } else {
        (left, data)
      }
    }
    def remove(elem:A):Node = {
      if(data >= elem && data <= elem) { //found the node
        if (right == null) left
        else if (left == null) right
        else { //2 kids
          val (n,v) = left.passUpMax()
          left = n
          data = v
          this
        }
      } else { //not at the node yet
        if(elem > data) right = right.remove(elem)
        else left = left.remove(elem)
        this
      }
    }
  }
  private var root:Node = null

  def getMax():A = {
    val (n,v) = root.passUpMax()
    root = n
    v
  }

  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem, null, null) else root.insert(elem)
  }
  def remove(elem:A):Unit = {
    root = root.remove(elem)
  }
  def contains(elem:A):Boolean = {
    if(root == null) false else root.contain(elem)
    /*
    var curr:Node = root
    while(curr != null) {
      if(curr.data == elem) return true
      else {
        if(elem > curr.data) curr = curr.right
        else curr = curr.left
      }
    }
    false*/
  }

  def printInOrder():Unit = {
    def workOnNode(n:Node):Unit = {
      if(n.left != null) workOnNode(n.left)
      print(n.data)
      if(n.right != null) workOnNode(n.right)
    }
    workOnNode(root)
  }

  def printPreOrderStack():Unit = {
    val stk = Stack[Node]()
    stk.push(root)
    while(!stk.isEmpty()) {
      val curr = stk.pop()
      if(curr != null) {
        print(curr.data)
        stk.push(curr.right)
        stk.push(curr.left)
      }
    }
  }

  def iterator:Iterator[A] = {
    new Iterator[A] {
      val stk = Stack[Node]()
      stk.push(root)

      def next():A = {
        var curr = stk.pop()
        while(curr == null) curr = stk.pop()
        val ret = curr.data
        stk.push(curr.right)
        stk.push(curr.left)
        ret
      }
      def hasNext:Boolean = {
        while(!stk.isEmpty && stk.peek() == null) stk.pop()
        !stk.isEmpty()
      }
    }
  }



}


