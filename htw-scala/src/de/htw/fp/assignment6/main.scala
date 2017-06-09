package de.htw.fp.assignment6

object test {
  def main(args: Array[String]) = {

    def runAssertionsCoins(coinOptions: (Int, List[Int]) => List[List[Int]]) = {
      // countCharFrequencies()

      val coinVersions = List(5, 2, 3)

      println("")
      println("checkPrice:")

      assert(coinOptions(0, List()), List())
      assert(coinOptions(0, List(0)), List())
      assert(coinOptions(0, coinVersions), List())
      assert(coinOptions(1, coinVersions), List())
      assert(coinOptions(2, coinVersions), List(List(2)))
      assert(coinOptions(3, coinVersions), 1)
      assert(coinOptions(4, coinVersions), 1)
      assert(coinOptions(5, coinVersions), List(List(5), List(2, 3)))
      assert(coinOptions(6, coinVersions), 2)
      assert(coinOptions(7, coinVersions), 2)
      assert(coinOptions(8, coinVersions), 3)
      assert(coinOptions(9, coinVersions), 3)
      //    assert(coinOptions(10, coinVersions), 4)
      //    assert(coinOptions(11, coinVersions), 4)
      //    assert(coinOptions(12, coinVersions), 5)

    }

    runAssertionsCoins(coins_with_solutionexport.countPricePossibilities2)
    //    runAssertionsCoins(coins_with_solutionexport.countPricePossibilities)

    def assert(a: Any, b: Any) =
      if (a == b) println("Jupp " + a + " == " + b)
      else println("Nope " + a + " != " + b)
  }
}