package de.htw.fp.assignment13

import scala.io.Source
import scala.annotation.tailrec

object Labyrinth_Breadth_First {

  type Labyrinth = Seq[Seq[Cell]]
  type Path = List[Position]

  def readLabyrinthFile(fn: String): Labyrinth = {
    try {
      (for (line <- Source.fromFile(fn, "UTF8").getLines.toList) yield for (c <- line) yield Cell(c == ' ', c == '?')).toIndexedSeq
    } catch {
      case _: java.io.FileNotFoundException => Nil
    }
  }

  def findPath(labyrinth: Labyrinth): Path = {

    def findStart(labyrinth: Labyrinth): Position = {
      for (y <- 0 until labyrinth.length) {
        for (x <- 0 until labyrinth(y).length) {
          if (labyrinth(y)(x).start)
            return Position(x, y)
        }
      }
      Position(-1, -1)
    }

    def isExit(p: Position, labyrinth: Labyrinth): Boolean = {
      val cell = labyrinth(p.y)(p.x)
      cell.free && (p.x == 0 || p.y == 0 || p.y == (labyrinth.length - 1) || p.x == (labyrinth(p.x).length - 1))
    }

    def isValidPosition(labyrinth: Labyrinth, p: Position): Boolean = {
      p.x >= 0 && p.x < labyrinth(0).length && p.y >= 0 && p.y < labyrinth.length
    }

    def isFree(labyrinth: Labyrinth, p: Position): Boolean = {
      labyrinth(p.y)(p.x).free
    }

    def notVisited(visited: Path, position: Position): Boolean = {
      !visited.contains(position)
    }

    def nonVisitedFreeNeighbours(labyrinth: Labyrinth, position: Position, path: Path): List[Position] = {
      List(position.right, position.bottom, position.left, position.top)
        .filter(p => isValidPosition(labyrinth, p) && isFree(labyrinth, p) && notVisited(path, p))
    }

    def depthFirstSearch(labyrinth: Labyrinth, position: Position, path: Path, visited: List[Position]): Path = {
      if (isExit(position, labyrinth)) position :: path
      else {
        val neighboursNotYetVisited = nonVisitedFreeNeighbours(labyrinth, position, visited)
        var p = (neighboursNotYetVisited.map {
          n => depthFirstSearch(labyrinth, n, path, n :: visited)
        } filter (n =>
          !n.isEmpty)
          map (n => position :: n))

        if (p.isEmpty)
          Nil
        else
          p.head

      }
    }

    def lösLAb(lab: Labyrinth, start: Position): Path = {

      def wegevon(von: Stream[Path], beendet: Set[Position]): Stream[Path] = {
        val längereWege = for {
          weg <- von
          neupos <- List(weg.head.top, weg.head.bottom, weg.head.right, weg.head.right)
          if (isValidPosition(lab, neupos) && isFree(lab, neupos))
          if (!notVisited(weg, neupos))
        } yield neupos :: weg
        längereWege
        //        längereWege #:: wegevon(längereWege, beendet)
        //          val neuposlist = längereWege.map(_.head)
        //          if(längereWege.isEmty) von// nil neues
        //          else von append wegvon (längereWege,  besucht ++ wenposlist)
        //          löslab
        //          val wege = wegean (STream(List(start)) , Set.empty)
        //          filter(weg=> ist ausgang(Weg.head, lab))
        //          if(wege.isEmpty) Nil else wege.head
      }

      println(wegevon(Stream(List(start)), Set()))
      List()
    }
    println(lösLAb(labyrinth, findStart(labyrinth)))

    List()
    //    depthFirstSearch(labyrinth, findStart(labyrinth), List(), List());
  }

}