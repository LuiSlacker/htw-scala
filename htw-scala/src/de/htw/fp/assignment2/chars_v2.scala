package de.htw.fp.assignment2

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

  def countNextLetter(l: List[Any]): List[(Any, Int)] = {
    if (l == Nil) Nil
    else {
      val newList = removeFromList(l.head, l)
      (l.head, length(l) - length(newList)) :: countNextLetter(newList)
    }
  }
  println("")
  println("removeFromList:")

  assert(removeFromList("t", List("t", "e", "s", "t")), List("e", "s"))
  assert(removeFromList("l", List("h", "a", "l", "l", "o")), List("h", "a", "o"))

  new assertions().runAssertionsChars(countNextLetter)

  def assert(a: Any, b: Any) =
    if (a == b) println("Jupp " + a + " == " + b)
    else println("Nope " + a + " != " + b)

}