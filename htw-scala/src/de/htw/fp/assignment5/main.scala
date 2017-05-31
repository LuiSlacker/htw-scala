package de.htw.fp.assignment5

object main {
  
  def main(args: Array[String]) = {
    
    val f: Fraction = Fraction(1, 2)
		val f2: Fraction = Fraction(6, 3)
		
		println(f == f2)
		println(f.add(f2))
		println(f.substract(f2))
		println(f.multiply(f2))
		println(f.divide(f2))
  }
}