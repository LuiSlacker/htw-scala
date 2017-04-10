

object Abgabe1 {

  // Implementiere folgende Funktionen auf Listen in strikt funktionaler Weise (keine Variablen) und „zu Fuß“, d.h. Funktionen aus dem Scala-API sollen nach Möglichkeit nicht verwendet werden, insbesondere natürlich nicht solche, die genau die gefragte Funktionalität liefern.

  def main(args: Array[String]) {

    def length(l: List[Any]): Int =
      if (l == Nil) 0
      else 1 + length(l.tail)

    println("Länge der Liste: " + length(List(1, 2, 3)))

    def take(l: List[Any], n: Int): List[Any] =
      if (l == Nil) l
      else if (n - 1 == 0) List(l.head)
      else l.head :: take(l.tail, n - 1)

    println("erste n Elemente der Liste: " + take(List(1, 2, 3, 4, 5), 2))

    def drop(l: List[Any], n: Int): List[Any] =
      if (l == Nil) l
      else if (length(l.tail) - n == 0) l.tail
      else drop(l.tail, n)

    println("Liste ohne erste n Elemente: " + drop(List(1, 2, 3, 4, 5, 6, 7), 5))

    def uniq(l: List[Any]): List[Any] =
      if (l == Nil || l.tail == Nil || l.tail.head == Nil) l
      else if (l.head != l.tail.head) l.head :: uniq(l.tail)
      else uniq(l.head :: l.tail.tail)

    println("Die Liste l ohne doppelte Elemente (mehrfach aufeinanderfolgende gleiche Elemente werden weggelassen)" +
      uniq(List(1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7, 7, 8)))

    def dupall(l: List[Any]): List[Any] =
      if (l == Nil) l
      else l.head :: l.head :: dupall(l.tail)

    println("die Liste l, in der alle Elemente verdoppelt sind" + dupall(List(1, 2, 3, 4, 5, 6)))

    //def insertAt (l: List[…], i: Int, x: …): List[…] und
    //def removeAt (l: List[…], i: Int): List[…]
    //Element an n-ter Stelle einfügen bzw. löschen

  }
}
