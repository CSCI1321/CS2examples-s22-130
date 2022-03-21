package cs2.algorithms

object ParametricSorting {

  def bubbleSort[A <% Ordered[A]] (arr:Array[A]):Unit = {
    for(j <- 0 until arr.length) {
      for(i <- 0 until arr.length-1) {
        if(arr(i) > arr(i+1)) {
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
      }
    }
  }

  def bubbleSort[A] (arr:Array[A], gt:(A,A)=>Boolean):Unit = {
    for(j <- 0 until arr.length) {
      for(i <- 0 until arr.length-1) {
        if(gt(arr(i), arr(i+1))) {
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
      }
    }
  }

  class Student(var first:String, var last:String, var gpa:Double) 
            extends Ordered[Student] {
    override def toString():String = last + ", " + first + ": " + gpa
    override def compare(other:Student):Int = {
      this.gpa.compare(other.gpa)
    }
  }


  def main(args:Array[String]):Unit = {
    val a = Array(3,2,6,4,1)
    val b = Array("Hello","Goodbye","Alice","Billy")
    val c = Array(new Student("Alice","Hardy",3.9),
                  new Student("Billy","Thorton",2.5),
                  new Student("Cindy","Mayweather",4.0))
    bubbleSort(a)
    bubbleSort(b)
    bubbleSort(c)
    println(a.mkString(", "))
    println(b.mkString(", "))
    println(c.mkString(", "))
  }
}