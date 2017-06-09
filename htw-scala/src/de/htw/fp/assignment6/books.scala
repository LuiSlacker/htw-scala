package de.htw.fp.assignment6

object books {
  def main(args: Array[String]) = {
    val books = List(
        Book("Scala Cookbook", List("A", "B", "C")),
        Book("Scala for the impatient", List("Cay Horstmann")),
        Book("Core Java for the impatient", List("Cay Horstmann")),
        Book("sdfsdf", List("B", "C"))
    )
    println(findAuthorsWithMultipleTitles(books))
  }
  
  case class Book(title: String, authors: List[String])
  
  def findAuthorsWithMultipleTitles(books: List[Book]): List[String] = {
      (for {
        book1 <- books
        book2 <- books
        if book1 != book2
        author1 <- book1.authors
        author2 <- book2.authors
        if author1 == author2
      } yield author1) distinct
  }
}