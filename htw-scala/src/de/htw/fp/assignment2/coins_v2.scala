package de.htw.fp.assignment2

import de.htw.fp.assignment2.assertions

object coins_v2 extends App {

  def addUpCoins(c: List[Int]): Int =
    if (c.isEmpty) 0
    else c.head + addUpCoins(c.tail)

  def countPricePossibilities(sum: Int, l: List[Int], goal: Int): Int = {
    def checkPrice(sum: Int, l: List[Int]): Int =
      if (l.isEmpty) 0
      else if (l.head + sum == goal) 1 + checkPrice(sum, l.tail)
      else if (l.head + sum > goal) checkPrice(sum, l.tail)
      else if (l.head + sum < goal) checkPrice(sum + l.head, l) + checkPrice(sum, l.tail)
      else 0
    checkPrice(sum, l)
  }

  new assertions().runAssertions(countPricePossibilities)

  val coinVersions = List(5, 2, 3)

  println("")
  println("checkPrice:")

  assert(countPricePossibilities(0, coinVersions, 0), 0)
  assert(countPricePossibilities(0, coinVersions, 1), 0)
  assert(countPricePossibilities(0, coinVersions, 2), 1)
  assert(countPricePossibilities(0, coinVersions, 3), 1)
  assert(countPricePossibilities(0, coinVersions, 4), 1)
  assert(countPricePossibilities(0, coinVersions, 5), 2)
  assert(countPricePossibilities(0, coinVersions, 6), 2)
  assert(countPricePossibilities(0, coinVersions, 7), 2)
  assert(countPricePossibilities(0, coinVersions, 8), 3)
  assert(countPricePossibilities(0, coinVersions, 9), 3)
  assert(countPricePossibilities(0, coinVersions, 10), 4)
  assert(countPricePossibilities(0, coinVersions, 11), 4)
  assert(countPricePossibilities(0, coinVersions, 12), 5)

  println("")
  println("addUpCoins:")
  assert(addUpCoins(List()), 0)
  assert(addUpCoins(List(23)), 23)
  assert(addUpCoins(List(2, 5, -10, 30)), 27)
  assert(addUpCoins(List(2, 5, 10, 30)), 47)

  def assert(a: Any, b: Any) =
    if (a == b) println("Jupp " + a + " == " + b)
    else println("Nope " + a + " != " + b)
}