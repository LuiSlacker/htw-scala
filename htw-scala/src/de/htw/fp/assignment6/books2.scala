package de.htw.fp.assignment6

object books2 {
  def main(args: Array[String]) = {

    val books = List(
      new Book("The Martian", List("Andy Weir")),
      new Book("Harry Potter", List("J. K. Rolling")),
      new Book("Bad Book 1", List("Andy Weir")),
      new Book("Bad Book 2", List("Andy Weir", "Peter Pan")),
      new Book("And The Cow Makes Moo", List("J. K. Rolling", "Andy Weir")),
      new Book("The Lake", List("Peter Gross")))

    val found = findAuthorsWithMultipleTitles(books)
    val expected = List("J. K. Rolling", "Andy Weir")

    println(found)
    println(expected)
    println(found == expected)

  }

  case class Book(title: String, authors: List[String])

  def findAuthorsWithMultipleTitles(books: List[Book]): List[String] = {

    books.map(book => {
      book.authors.map(author => {
        author
      })
    }).flatten
      .groupBy(x => x)
      .filter((t) => t._2.length > 1)
      .keys
      .toList
  }
}