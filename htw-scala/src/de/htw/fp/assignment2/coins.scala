package de.htw.fp.assignment2

object coins {
  def main(args: Array[String]) {
    // val coinDenominations: List[Int] = List(1, 2, 5)
    // println(coinOptions(3, coinDenominations))

    new assertions().runAssertionsCoins(coinOptions)
  }

  /**
   * returns number of possible denominations for a given price
   * @param price the price to achieve
   * @param coinDenominations the list of possible coins
   */
  def coinOptions(price: Int, coinDenominations: List[Int]): Int = {
    def count(price: Int, coinDenominations: List[Int], counter: Int): Int = {
      if (price == 0) counter + 1
      else if (price < 0 || coinDenominations.isEmpty) counter
      else count(price - coinDenominations.head, coinDenominations, counter) + count(price, coinDenominations.tail, counter)
    }

    if (price <= 0) 0
    else count(price, coinDenominations, 0)
  }
}