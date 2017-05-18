package de.htw.fp.assignment4

import scala.io.Source

object main {
  def main(args: Array[String]) {
    val basePath = "src/de/htw/fp/assignment4/";
    val labyrinth: Labyrinth = readLabyrinthFile(basePath + "labyrinth3.txt")
    println(labyrinth)
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
  
  def findPath(labyrinth: Labyrinth): Position = {
    
    def findStart(labyrinth: Labyrinth): Position = {
      Position(1, 2)
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
    
    def nonVisitedNeighbours(labyrinth: Labyrinth, position: Position, visited: Path): List[Position] = {
      println(position)
      List(position.right, position.bottom, position.left, position.top)
        .filter (p => isValidPosition(labyrinth, p) && isFree(labyrinth, p) && !visited.contains(p))
    }
    
    def depthFirstSearch(labyrinth: Labyrinth, path: Path, stack: List[Position], visited: Path): Position = {
      if (isExit(stack.head, labyrinth) || stack.isEmpty) stack.head
      else {
        val neighbours: List[Position] = nonVisitedNeighbours(labyrinth, stack.head, visited)
        println(neighbours)
        depthFirstSearch(labyrinth, path, neighbours ::: stack.tail, stack.head :: visited)
      }
    }
    
    depthFirstSearch(labyrinth, List(), List(Position(0, 1)), List())
    
  }
  
}