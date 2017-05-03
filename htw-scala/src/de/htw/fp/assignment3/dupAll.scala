package de.htw.fp.assignment3

import scala.annotation.tailrec

object dupAll {
  def main(args: Array[String]) {
    val list = List(1, 2, 3)
    println(dupAll2(list))
    
  }
  
  def dupAll(l: List[Int]): List[Int] =
    l.flatMap(x => List(x, x))
    
    
  def dupAll2(l: List[Int]): List[Int] =
    if (l.isEmpty) l
    else l.head :: dupAll2(l.tail)
    
}