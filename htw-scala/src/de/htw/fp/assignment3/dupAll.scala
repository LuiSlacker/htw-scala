package de.htw.fp.assignment3

import scala.annotation.tailrec

object dupAll {
  def main(args: Array[String]) {
    val list = List(1, 2, 3)
    println(dupAll2(list))
    
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
  
  /**
   * refactored dupAll with one omitted function
   */
  def dupAll2(l: List[Int]): List[Int] = {
    
    def prependEl: ListEnhancer = (el: Int, list: List[Int]) => el :: list
    def prependElTwice: ListEnhancer = (el: Int, list: List[Int]) => el :: el :: list
    
    type ListEnhancer = (Int, List[Int]) => List[Int]
    
    @tailrec def tailRecMap(all: List[Int], acc: List[Int], f: ListEnhancer): List[Int] = {
      if (all.isEmpty) acc
      else tailRecMap(all.tail, f(all.head, acc), f)
    }
    
    tailRecMap(tailRecMap(l, List(), prependElTwice), List(), prependEl)
  }
  
 }