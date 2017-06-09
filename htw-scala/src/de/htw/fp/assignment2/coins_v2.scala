package de.htw.fp.assignment2

object coins_v2 extends App {

  def countPricePossibilities(goal: Int, l: List[Int]): Int = {
    def checkPrice(sum: Int, l: List[Int]): Int =
      if (goal == 0) 1
      else if (l.isEmpty) 0
      else if (goal == sum) 1
      else if (sum > goal) checkPrice(sum, l.tail)
      else if (sum < goal) checkPrice(sum + l.head, l) + checkPrice(sum, l.tail)
      else 0

    checkPrice(0, l)
  }

  new assertions().runAssertionsCoins(countPricePossibilities)
}