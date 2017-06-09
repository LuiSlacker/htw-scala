package de.htw.fp.assignment6

object test {
  def main(args: Array[String]) = {

    def runAssertionsCoins(coinOptions: (Int, List[Int]) => List[List[Int]]) = {

      val coinVersions = List(5, 2, 3)

      println("")
      println("retrieve coinlist solutions:")

      assert(coinOptions(0, List()), List(List()))
      assert(coinOptions(0, List(0)), List(List()))
      assert(coinOptions(0, coinVersions), List(List()))
      assert(coinOptions(1, coinVersions), List())
      assert(coinOptions(2, coinVersions), List(List(2)))
      assert(coinOptions(3, coinVersions), List(List(3)))
      assert(coinOptions(4, coinVersions), List(List(2, 2)))
      assert(coinOptions(5, coinVersions), List(List(5), List(3, 2)))
      assert(coinOptions(6, coinVersions), List(List(2, 2, 2), List(3, 3)))
      assert(coinOptions(7, coinVersions), List(List(2, 5), List(3, 2, 2)))
      assert(coinOptions(8, coinVersions), List(List(3, 5), List(2, 2, 2, 2), List(3, 3, 2)))
      assert(coinOptions(9, coinVersions), List(List(2, 2, 5), List(3, 2, 2, 2), List(3, 3, 3)))
      assert(coinOptions(10, coinVersions), List(List(5, 5), List(3, 2, 5), List(2, 2, 2, 2, 2), List(3, 3, 2, 2)))
      assert(coinOptions(11, coinVersions), List(List(2, 2, 2, 5), List(3, 3, 5), List(3, 2, 2, 2, 2), List(3, 3, 3, 2)))
      assert(coinOptions(12, coinVersions), List(List(2, 5, 5), List(3, 2, 2, 5), List(2, 2, 2, 2, 2, 2), List(3, 3, 2, 2, 2), List(3, 3, 3, 3)))

    }

    runAssertionsCoins(coins_with_solutionexport.countPricePossibilities)

    def assert(a: Any, b: Any) =
      if (a == b) println("Jupp " + a + " == " + b)
      else println("Nope " + a + " != " + b)
  }
}