package de.htw.fp.assignment6

object books {
  def main(args: Array[String]) = {
    val books = List(
        Book("Scala Cookbook", List("A", "B", "C")),
        Book("sdfsdf", List("B"))
    )
  }
  
  case class Book(title: String, authors: List[String])
  
  def findAuthorsWithMultipleTitles(books: List[Book]): List[String] = {
    List()
  }
}