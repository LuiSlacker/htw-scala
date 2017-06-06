package de.htw.fp.assignment6

object balanced {
  def main(args: Array[String]) = {
    println(String.format("x(x(x)) %s", String.valueOf(balanced("x(x(x))"))))
    println(String.format("(a)(b()) %s", String.valueOf(balanced("(a)(b())"))))
    println(String.format("a( %s", String.valueOf(balanced("a("))))
    println(String.format(")x( %s", String.valueOf(balanced(")x("))))
  }
  
  def balanced(input: String): Boolean = {
    
    def check(string: List[Char], count: Int): Boolean = {
      string match {
        case Nil => count == 0
        case ')' :: _ if (count < 1)  => false
        case '(' :: rest => check(rest, count + 1)
        case ')' :: rest => check(rest, count - 1)
        case _ :: rest => check(rest, count)
      }
    }
    
    check(input.toList, 0)
  }
  
}