package de.htw.fp.assignment4

import scala.annotation.tailrec
import scala.io.Source

object main_tailRecursive {
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
    
    def notVisited(path: Path, position: Position): Boolean = {
      !path.contains(position)
    }
    
    def nonVisitedFreeNeighbours(labyrinth: Labyrinth, position: Position, path: Path): List[Position] = {
    		List(position.right, position.bottom, position.left, position.top)
    		.filter (p => isValidPosition(labyrinth, p) && isFree(labyrinth, p) && notVisited(path, p))
    }
    
    def filterNeighbours(list: List[Position]): List[Position] = {
      
      def areNeighbours(a: Position, b: Position): Boolean = {
        math.abs(a.x - b.x) <= 1 && math.abs(a.y - b.y) == 0 ||
        math.abs(a.x - b.x) == 0 && math.abs(a.y - b.y) <= 1
      }
      
      def filter(list: List[Position], ancestor: Position = Position(-3, -3), filteredList: List[Position]): List[Position] = {
        if (list.isEmpty) filteredList
        else if(areNeighbours(list.head, ancestor)) filter(list.tail, list.head, list.head :: filteredList)
        else filter(list.tail, filteredList.head, filteredList)
      }
      
      filter(list, list.head, List())
    }
    
    @tailrec
    def depthFirstSearch(labyrinth: Labyrinth, path: Path, stack: List[Position]): Path = {
      if (isExit(stack.head, labyrinth)) stack.head :: path
      else
        depthFirstSearch(labyrinth, stack.head :: path, nonVisitedFreeNeighbours(labyrinth, stack.head, path) ::: stack.tail)
    }
   
    filterNeighbours(
        depthFirstSearch(labyrinth, List(), List(findStart(labyrinth)))
    )
  }
  
}