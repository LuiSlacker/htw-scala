package de.htw.fp.assignment2

import de.htw.fp.assignment2.assertions
object chars_v2 extends App {

  def length(l: List[Any]): Int =
    if (l == Nil) 0
    else 1 + length(l.tail)

  def removeFromList(item: Any, l: List[Any]): List[Any] = {
    if (l == Nil) List()
    else if (item == l.head) {
      removeFromList(item, l.tail)
    } else {
      l.head :: removeFromList(item, l.tail)
    }
  }

  def countSameItems(l: List[Any]): List[(Any, Int)] = {
    val ammounts: List[(Any, Int)] = List()

    def countNextLetter(l: List[Any]): List[(Any, Int)] = {
      if (l == Nil) Nil
      else {
        val newList = removeFromList(l.head, l)
        (l.head, length(l) - length(newList)) :: countNextLetter(newList)
      }
    }
    countNextLetter(l)
  }

  new assertions()

  println("")
  println("removeFromList:")

  assert(removeFromList("t", List("t", "e", "s", "t")), List("e", "s"))
  assert(removeFromList("l", List("h", "a", "l", "l", "o")), List("h", "a", "o"))

  println("")
  println("countSameItems:")
  assert(countSameItems(List("t", "e", "s", "t")), List(("t", 2), ("e", 1), ("s", 1)))
  assert(countSameItems(List("h", "a", "l", "l", "o")), List(("h", 1), ("a", 1), ("l", 2), ("o", 1)))
  assert(countSameItems(List("h", "a", "l", "l", "a", "o")), List(("h", 1), ("a", 2), ("l", 2), ("o", 1)))

  def assert(a: Any, b: Any) =
    if (a == b) println("Jupp " + a + " == " + b)
    else println("Nope " + a + " != " + b)

}