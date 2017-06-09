package de.htw.fp.assignment6


object coins_Reloaded {
  def main(args: Array[String]) {
    println(coinOptions(9, List(1, 2, 5)))
  }

  /**
   * returns a List of possible denominations for a given price
   * @param price the price to achieve
   * @param coinDenominations the list of possible coins
   */
  def coinOptions(price: Int, coinDenominations: List[Int]): List[List[Int]] = {
    def count(price: Int, coinDenominations: List[Int], coinsTaken: List[Int], possibilities:List[List[Int]]): List[List[Int]] = {
      if (price == 0) coinsTaken :: possibilities
      else if (price < 0 || coinDenominations.isEmpty) possibilities
      else
        count(price - coinDenominations.head, coinDenominations, coinDenominations.head :: coinsTaken, possibilities) :::
        count(price, coinDenominations.tail, coinsTaken, possibilities)
    }

    count(price, coinDenominations, List(), List())
  }
}