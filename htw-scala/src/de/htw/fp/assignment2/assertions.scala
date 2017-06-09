package de.htw.fp.assignment2

class assertions {

  def runAssertionsChars(chars: List[Any] => List[(Any, Int)]) = {

    println("")
    println("countSameItems:")
    assert(chars("test".toList), List(("t", 2), ("e", 1), ("s", 1)))
    assert(chars("hallo".toList), List(("h", 1), ("a", 1), ("l", 2), ("o", 1)))
    assert(chars("halloa".toList), List(("h", 1), ("a", 2), ("l", 2), ("o", 1)))

  }
  def runAssertionsCoins(coinOptions: (Int, List[Int]) => Int) = {
    // countCharFrequencies()

    val coinVersions = List(5, 2, 3)

    println("")
    println("checkPrice:")

    assert(coinOptions(0, List()), 1)
    assert(coinOptions(0, List(0)), 1)
    assert(coinOptions(0, coinVersions), 1)
    assert(coinOptions(1, coinVersions), 0)
    assert(coinOptions(2, coinVersions), 1)
    assert(coinOptions(3, coinVersions), 1)
    assert(coinOptions(4, coinVersions), 1)
    assert(coinOptions(5, coinVersions), 2)
    assert(coinOptions(6, coinVersions), 2)
    assert(coinOptions(7, coinVersions), 2)
    assert(coinOptions(8, coinVersions), 3)
    assert(coinOptions(9, coinVersions), 3)
    assert(coinOptions(10, coinVersions), 4)
    assert(coinOptions(11, coinVersions), 4)
    assert(coinOptions(12, coinVersions), 5)

  }
  def assert(a: Any, b: Any) =
    if (a == b) println("Jupp " + a + " == " + b)
    else println("Nope " + a + " != " + b)

}