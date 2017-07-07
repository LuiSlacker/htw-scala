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

  def findPath(labyrinth: Labyrinth): Stream[Path] = {

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
      if (isValidPosition(labyrinth, p))
        labyrinth(p.y)(p.x).free && (p.x == 0 || p.y == 0 || p.y == (labyrinth.length - 1) || p.x == (labyrinth(0).length - 1))
      else
        false
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

    def lösLab(lab: Labyrinth, start: Position): Stream[Path] = {
      
      def wegevon(von: Stream[Path], beendet: Set[Position]): Stream[Path] = {
        val längereWege = for {
          weg <- von
          neupos <- List(weg.head.top, weg.head.bottom, weg.head.right, weg.head.left)
          if (isValidPosition(lab, neupos) && isFree(lab, neupos))
          if (notVisited(weg, neupos))
        } yield neupos :: weg

        val neuposlist = längereWege.map(_.head)
        if (längereWege.isEmpty)
          von // nil neues
        else
          von append wegevon(längereWege, beendet)

      }

      val wege = wegevon(Stream(List(start)), Set.empty)
        .filter(weg => isExit(weg.head, lab))
        
      wege
    }

    
    lösLab(labyrinth, findStart(labyrinth))

  }

}