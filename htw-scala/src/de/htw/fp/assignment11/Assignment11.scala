package de.htw.fp.assignment11

object Assignment11 {

  /**
   * Aufgabe 11 (7. Abgabe) 2 Punkte
   *
   * Realisiere die Lösung des Labyrinths parallel,
   * unter Verwendung von Parallelisierungsmitteln der Wahl.
   * Die Lösungen sollen ausgegeben werden, Ausgaben sind zu synchronisieren,
   * damit jede Lösung zusammenhängend erscheint.
   * Nach Ausgabe ausreichend vieler Lösungen sollte das Programm beendet werden,
   * d.h. noch laufende Suchen sollten geeignet terminiert werden.
   */

  def main(args: Array[String]) = {

    val basePath = "src/de/htw/fp/assignment4/";
    val labyrinth: main_recusive_par.Labyrinth = main_recusive_par.readLabyrinthFile(basePath + "labyrinth1.txt")

    assert(
      main_recusive_par.findPath(labyrinth),
      List((0, 1), (1, 1), (2, 1), (2, 2),
        (2, 3), (1, 3), (1, 4), (1, 5),
        (2, 5), (3, 5), (3, 4), (4, 4),
        (4, 3), (4, 2), (4, 1), (5, 1),
        (6, 1), (6, 2), (6, 3), (7, 3)))

  }

  def assert(a: List[Any], b: List[Any]) = {
    //    List.equals(a,b)
    println("Comparing")
    (a.zip(b).foreach(x => println(x)))

    //    if (a == b) println("Jupp " + a + " == " + b)
    //    else println("Nope " + a + " != " + b)
  }

}