package cs2.adt

abstract class Set[A] extends Iterable[A] {
  //Abstract methods (contract)
  def add(elem:A):Unit
  def remove(elem:A):Unit
  def contains(elem:A):Boolean
  def size:Int
  //Also, iterator():Iterator[A]

  //Concrete methods
  def intersect(other:Set[A]):Set[A] = {
    val result = Set[A]()
    for(x <- this) {
      if(other.contains(x)) result.add(x)
    }
    result
  }
  def difference(other:Set[A]):Set[A] = {
    val result = Set[A]()
    for(x <- this) {
      if(!other.contains(x)) result.add(x)
    }
    result
  }
  def union(other:Set[A]):Set[A] = {
    val result = Set[A]()
    for(x <- this) result.add(x)
    for(x <- other) result.add(x)
    result
  }
}

object Set {
  def apply[A]():Set[A] = ???
}

