package de.htw.fp.assignment13

object Assignment13 {

  type Labyrinth = Seq[Seq[Cell]]
  type Path = List[Position]
  /**
   * Realisiere die Lösung des Labyrinths 
   * nach der Breadth-First-Strategie durch 
   * Erzeugung eines Streams der Pfade bzw. Lösungspfade.
   * 
   * HHHHHH
   * ?   HH
   * HH HHH
   *
   */

  def main(args: Array[String]) = {

    val basePath = "src/de/htw/fp/assignment4/";
    val labyrinth: Labyrinth_Breadth_First.Labyrinth =
      Labyrinth_Breadth_First.readLabyrinthFile(basePath + "labyrinth4.txt")
//      Labyrinth_Breadth_First.readLabyrinthFile(basePath + "labyrinth1.txt")

//    assert(
      val a = Labyrinth_Breadth_First.findPath(labyrinth)
      
    println(a.toList)
    println(a.map(_.length).toList)
      
//      List(List((0, 1)),
//        List((0, 1), (1, 1)),
//        List((0, 1), (1, 1), (2, 1)),
//        List((0, 1), (1, 1), (2, 1), (3, 1)),
//        List((0, 1), (1, 1), (2, 1), (2, 2))))

  }

  def assert(a: List[Any], b: List[Any]) = {
    //    List.equals(a,b)
    println("Comparing")
    (a.zip(b).foreach(x => println(x)))

    //    if (a == b) println("Jupp " + a + " == " + b)
    //    else println("Nope " + a + " != " + b)
  }

}