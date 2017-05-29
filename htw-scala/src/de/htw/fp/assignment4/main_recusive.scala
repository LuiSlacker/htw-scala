package de.htw.fp.assignment4

import scala.io.Source
import scala.annotation.tailrec

object main_recusive {
  def main(args: Array[String]) {
    val basePath = "src/de/htw/fp/assignment4/";
    val labyrinth: Labyrinth = readLabyrinthFile(basePath + "labyrinth1.txt")
    println(findPath(labyrinth))
  }
  
  type Labyrinth = Seq[Seq[Cell]]
  type Path = List[Position]
  
  def readLabyrinthFile(fn: String): Labyrinth = {
    try{
      (for(line <- Source.fromFile(fn, "UTF8").getLines.toList) yield
        for (c <- line) yield Cell(c == ' ', c == '?')
      ).toIndexedSeq
    } catch {
      case _: java.io.FileNotFoundException => Nil
    }
  }
  
  def findPath(labyrinth: Labyrinth): Path = {
    
    def findStart(labyrinth: Labyrinth): Position = {
      for(y <- 0 until labyrinth.length) {
        for (x <- 0 until labyrinth(y).length) {
          if (labyrinth(y)(x).start) 
            return Position(x, y)
        }
      }
      Position(-1, -1)
    }
    
    def isExit(p: Position, labyrinth: Labyrinth): Boolean =  {
      val cell = labyrinth(p.y)(p.x)
      cell.free && (p.x == 0 || p.y == 0 || p.y == (labyrinth.length - 1) || p.x == (labyrinth(p.x).length - 1))
    }
    
    def isValidPosition(labyrinth: Labyrinth, p: Position): Boolean = {
    		p.x >= 0 && p.x < labyrinth(0).length && p.y >=0 && p.y < labyrinth.length
    }
    
    def isFree(labyrinth: Labyrinth, p: Position): Boolean =  {
      labyrinth(p.y)(p.x).free
    }
    
    def notVisited(visited: Path, position: Position): Boolean = {
      !visited.contains(position)
    }
    
    def nonVisitedFreeNeighbours(labyrinth: Labyrinth, position: Position, path: Path): List[Position] = {
    		List(position.right, position.bottom, position.left, position.top)
    		.filter (p => isValidPosition(labyrinth, p) && isFree(labyrinth, p) && notVisited(path, p))
    }
    
    def depthFirstSearch(labyrinth: Labyrinth, position: Position, path: Path, visited: List[Position]): Path = {
      if (isExit(position, labyrinth)) position :: path
      else {
        val neighboursNotYetVisited = nonVisitedFreeNeighbours(labyrinth, position, visited)
        neighboursNotYetVisited.foreach { n =>
          val rec = depthFirstSearch(labyrinth, n, path, n :: visited)
          if (!rec.isEmpty) return position :: rec
        }
        
        Nil
      }
    }
    
    depthFirstSearch(labyrinth, findStart(labyrinth), List(), List());
    
  }
}