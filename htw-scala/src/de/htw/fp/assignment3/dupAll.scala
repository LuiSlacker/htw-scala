package de.htw.fp.assignment3

import scala.annotation.tailrec

object dupAll {
  def main(args: Array[String]) {
    val list = List(1, 2, 3)
    println(dupAll(list))
    
  }
  
  def dupAll(l: List[Int]): List[Int] = {
    
    @tailrec def duplicate(all: List[Int], acc: List[Int]): List[Int] = {
      if (all.isEmpty) acc
      else duplicate(all.tail, all.head :: all.head :: acc)
    }
    
    @tailrec def reverse(all: List[Int], acc: List[Int]): List[Int] = {
      if (all.isEmpty) acc
      else reverse(all.tail, all.head :: acc)
    }
    
    reverse(duplicate(l, List()), List())
  }
  
 }