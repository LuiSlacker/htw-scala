package de.htw.fp.assignment5

object main {
  
  def main(args: Array[String]) = {
    
    val f: Fraction = Fraction(2, 3)
		val f2: Fraction = Fraction(4, 6)
		val f3: Fraction = Fraction(5, 6)
		
		println(String.format("%s == %s ? %s", f, f2, String.valueOf(f == f2)))
		println(String.format("%s == %s ? %s", f, f3, String.valueOf(f == f3)))
		
		println(String.format("%s + %s ? %s", f, f2, f.add(f2)))
		println(String.format("%s - %s ? %s", f, f3, f.substract(f3)))
		
		println(String.format("%s * %s ? %s", f, f3, f.multiply(f3)))
		println(String.format("%s / %s ? %s", f, f3, f.divide(f3)))
		
  }
}