package de.htw.fp.assignment2

object chars {
  def main(args: Array[String]) {
    println(countCharFrequencies("hello"))
  }
  
  /**
   * generates a map of char frequencies within a given string
   */
  def countCharFrequencies(s: String): Map[Char, Int] = {

    def count(chars: List[Char], frequencies: Map[Char, Int]): Map[Char, Int] = {
      chars match {
        case Nil => frequencies
        case char :: rest => count(rest, frequencies + (char -> (frequencies(char) + 1)))
      }
    }
    
    count(s.toList, Map.empty[Char, Int] withDefaultValue 0)
  }
}