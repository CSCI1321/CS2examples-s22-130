package cs2.adt

class BinarySearchTree[A <% Ordered[A]] {
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
  }
  private var root:Node = null

  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem, null, null) else root.insert(elem)
  }
  def remove(elem:A):Unit = ???
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


}


