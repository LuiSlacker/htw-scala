package de.htw.fp.mitschriften

object seminar4 extends App {
  /*
   * Da nächste Vorlesung ausfällt wird größeres Projekt vorgestellt
   * */

  /*
   * Scala Klassensystem: 
   * keyowrd: class
   * (default) constructor:*/
  class ComplexClass(rei: Double, im: Double) {
  }

  val c1 = new ComplexClass(2.3, 1.2)

  /*
   * saubere unterscheidung als in java
   * es gibt ein "companion object": */
  object ComplexCompantion {
    val i = new ComplexClass(0, 1)
  }

  /*
   * Case Class:
   * bei case class sind parameter immutable */
  case class ComplexCase(a: Double, b: Double) {

  }

  val c2 = ComplexCase(3.4, 6.8)

  /*
   * als Pattern: */
  c2 match {
    case ComplexCase(0, 1) => println("test")
  }

  trait C {
    def f1() {}
  }
  trait C2 {}

  /* Java Interface -> Scala trait 
   * kann funktionsimplementierung enthalten
   * geeignet für multiple inheritence */
  abstract class D extends C with C2 {
    override def f1
  }

  /*package, import*/
  def fx() = {
    // import p1,_ // alle Klassen z.B. P1a

    // val p: P1A = ...
  }

  /*
   * AUFGABE:
   * 
   * Löse ein Problem, das einen Lösungsbaum hat z.B. den weg in einem Labyrinth finden
   * es geht nciht darum den besten weg sondern einfach mindetens einen weg zu finden */
  // Rubicks cube

  /*
   * 001
   * 00?
   * 011
   * 
   * ? ist Start
   * anderes ist leer
   * 1 ist wand
   * */

  case class Zelle(frei: Boolean, start: Boolean)

  case class Pos(x: Int, y: Int) {
    def Nord = Pos(x, y - 1)
    def Süd = Pos(x, y + 1)
    def West = Pos(x - 1, y)
    def Ost = Pos(x + 1, y)

    override def toString = "x" + x + "Y " + y
  }

  type Labyrinth = Seq[Seq[Zelle]]

  def istAusgang(p: Pos, lab: Labyrinth) = {
    val zelle = lab(p.y)(p.x)

    zelle.frei && (p.x == 0 || p.y == 0 || p.y == (lab.length - 1) || p.x == (lab(p.x).length - 1))

  }

  type Weg = List[Pos]

  def hierWarIchSchon(p: Pos, w: Weg) {
    w.contains(p)
  }
  /**
   * LabyrinthDaeefe: " " : frei Zelle
   * "?": Startposition
   * sonst: wand
   */
  /*           
   def lieslab(fn: String):Labyrinth =
     try{
       (for(zeile <= java.io.Source.fromFile(fn, "UTF8").getLines.toList) yield
       for (c <= zeile) yield Zlle(c == ' ', c == '?')
       ).toIndexedSeq
     }catch{
       case _: java.io.FileNotFoundException => Nil
     }*/
}