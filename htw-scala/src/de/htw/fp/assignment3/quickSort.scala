package de.htw.fp.assignment3

object quickSort {
  def main(args: Array[String]) {
    val l = List(5,3,7,5,2,6,4)
    println(quickSort(l))
  }
  
  def quickSort(l: List[Int]) : List[Int] =
    if (l.isEmpty) l
    else {
      val pivot: Int = l.head
      quickSort(l.filter(_ < pivot)) ::: l.filter(_ == pivot) ::: quickSort(l.filter(_ > pivot))
    }
}