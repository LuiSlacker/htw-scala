package de.htw.fp.assignment2

object coins_v2 extends App {

  def countPricePossibilities(goal: Int, l: List[Int]): Int = {
    def checkPrice(sum: Int, l: List[Int]): Int =
      if (l.isEmpty || sum > goal) 0
      else if (goal == sum) 1
      else checkPrice(sum + l.head, l) + checkPrice(sum, l.tail)

    if (goal == 0)
      1
    else
      checkPrice(0, l)
  }

  new assertions().runAssertionsCoins(countPricePossibilities)
}