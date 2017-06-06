package de.htw.fp.assignment6


object coins_Reloaded {
  def main(args: Array[String]) {
    println(coinOptions(3, List(1, 2, 5)))
  }

  /**
   * returns number of possible denominations for a given price
   * @param price the price to achieve
   * @param coinDenominations the list of possible coins
   */
  def coinOptions(price: Int, coinDenominations: List[Int]): Int = {
    def count(price: Int, coinDenominations: List[Int], counter: Int, coins:List[Int]): Int = {
      if (price == 0) counter + 1
      else if (price < 0 || coinDenominations.isEmpty) counter
      else count(price - coinDenominations.head, coinDenominations, counter, coinDenominations.head :: coins) + count(price, coinDenominations.tail, counter, coins)
    }

    count(price, coinDenominations, 0, List())
  }
}