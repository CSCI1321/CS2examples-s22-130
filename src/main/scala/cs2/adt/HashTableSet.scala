package cs2.adt

class HashTableSet[A <% Ordered[A]] extends Set[A] {
  private var ht:Array[BinarySearchTree[A]] = Array.fill(100)(new BinarySearchTree[A]())
  private var len:Int = 0

  private def getBucket(elem:A) = elem.hashCode() % ht.length

  def add(elem:A):Unit = {
    val b = getBucket(elem)
    if(!ht(b).contains(elem)) {
      ht(b).insert(elem)
      len += 1
    }
  }
  def remove(elem:A):Unit = {
    val b = getBucket(elem)
    if(ht(b).contains(elem)) {
      ht(b).remove(elem)
      len -= 1
    }
  }
  def contains(elem:A):Boolean = {
    ht(getBucket(elem)).contains(elem)
  }
  override def size:Int = len

  def iterator:Iterator[A] = {
    new Iterator[A] {
      private var bucket = 0
      private var bstit = ht(0).iterator

      private def advance():Unit = {
        while(!bstit.hasNext && bucket < ht.length - 1) {
          bucket += 1
          bstit = ht(bucket).iterator
        }
      }

      def next():A = {
        if(bstit.hasNext) bstit.next
        else {
          advance()
          bstit.next
        }
      }
      def hasNext:Boolean = {
        if(bstit.hasNext) true
        else {
          //while bucket is empty AND there are more buckets
          advance()
          bstit.hasNext
        }
      }
    }
  }
}