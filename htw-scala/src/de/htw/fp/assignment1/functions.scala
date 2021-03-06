

package de.htw.fp.assignment1

object functions {
  
  def main(args: Array[String]) {
    val nums: List[Int] = List(1, 2, 3, 4, 5, 6)
    
    println("List(1, 2, 3, 4, 5, 6)")
    println("Length: " + length(nums))
    println("Take first 2 Elements: " + take(nums, 2));
    println("Drop first 2 Elements: " + drop(nums, 2))
    println("Duplicate all elements: " + dupall(nums))
    println("Add -1 at 2nd position: " + insertAt(nums, 2, -1))
    println("Remove element at 2nd position: " + removeAt(nums, 2))
    
    val doubles: List[Int] = List(7, 7, 2, 3, 3, 4, 5, 5, 6)
    println("Remove duplicates: " + uniq(doubles))
    
  }
  
  /**
   * returns the length of a list
   */
  def length(l: List[Int]): Int =
    if (l.isEmpty) 0
    else length(l.tail) + 1
    
    
  /**
   * returns the first n elements from a list 
   */
  def take(l: List[Int], n: Int): List[Int] =
    if (n == 0 || l.isEmpty) Nil
    else l.head :: take(l.tail, n-1)
    
    
  /**
   * returns list without the first n elements
   */
  def drop(l: List[Int], n: Int): List[Int] =
    if (n == 0 || l.isEmpty) l
    else drop(l.tail, n-1)
    
  
  /**
   * removes successive duplicates from a list
   * NOTE: not tail-recursive
   */
  def uniq(l: List[Int]): List[Int] =
    if (l.isEmpty) l
    else if (l.tail.isEmpty || l.head != l.tail.head) l.head :: uniq(l.tail)
    else uniq(l.tail)
    
  /**
   * duplicates all elements
   */
  def dupall (l: List[Int]): List[Int] =
    if (l.isEmpty) l
    else l.head :: l.head :: dupall(l.tail)
    
    
  /**
   * inserts an element x at position i within a list
   */
  def insertAt(l: List[Int], i: Int, x: Int): List[Int] =
    if (l.isEmpty) x :: Nil
    else if (i == 0) x :: l
    else l.head :: insertAt(l.tail, i-1, x)
    
    
  /**
   * returns a list without n-th element
   */
  def removeAt (l: List[Int], i: Int): List[Int] =
    if (l.isEmpty) l
    else if (i == 0) l.tail
    else l.head :: removeAt(l.tail, i-1)
    
}