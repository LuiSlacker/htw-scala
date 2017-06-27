package de.htw.fp.assignment12

object NFibonacciNumbers {
  def main(args: Array[String]) = {
        assert(NFibonacciNumbers(-1), List())
        assert(NFibonacciNumbers(0), List())
    assert(NFibonacciNumbers(1), List(0))
    assert(NFibonacciNumbers(2), List(0, 1))
    assert(NFibonacciNumbers(3), List(0, 1, 1))
    assert(NFibonacciNumbers(4), List(0, 1, 1, 2))
    assert(NFibonacciNumbers(5), List(0, 1, 1, 2, 3))
    assert(NFibonacciNumbers(6), List(0, 1, 1, 2, 3, 5))
  }

  def assert(a: Any, b: Any) = {
    if (a == b) println("Jupp " + a + " == " + b)
    else println("Nope " + a + " != " + b)
  }

  def NFibonacciNumbers(goalNumber: Int): List[Int] = {
    def tmp(counter: Int, goalNumber: Int, list: List[Int]): List[Int] = {
      if (counter == goalNumber)
        Nil
      else if (counter == 0)
        0 :: tmp(counter + 1, goalNumber, 0 :: list)
      else if (counter == 1)
        1 :: tmp(counter + 1, goalNumber, 1 :: list)
      else (list.head + list.tail.head) :: tmp(counter + 1, goalNumber, (list.head + list.tail.head) :: list)

    }

    if (goalNumber <= 0) List()
    else
      tmp(0, goalNumber, List())
  }
}