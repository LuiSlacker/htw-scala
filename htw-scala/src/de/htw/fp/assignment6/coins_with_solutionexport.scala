package de.htw.fp.assignment6

import scala.collection.mutable.Stack

object coins_with_solutionexport extends App {
  //def münzStückelungen (werte: List[Int], betrag: Int): List[List[Int]]

  def sumup(l: List[Int]): Int = {
    if (l.isEmpty) 0
    else sumup(l.tail) + l.head
  }
  
  def countPricePossibilities2(goal: Int, l: List[Int]): List[List[Int]] = {

    def checkPrice(sumList: List[Int], l: List[Int], solutions: List[List[Int]]): List[List[Int]] = {
      val sum = sumup(sumList)
      //      println(sum, sumList)
      if (goal == 0) List(Nil)
      else if (l.isEmpty) solutions
      else if (goal == sum) sumList :: solutions
      else if (sum > goal) checkPrice(sumList, l.tail, solutions)
      else if (sum < goal) checkPrice(l.head :: sumList, l, solutions) ::: checkPrice(sumList, l.tail, solutions)

      Nil
    }
    var t = checkPrice(List(), l, List[List[Int]]())

    println(t)
    t
  }
    def countPricePossibilities(goal: Int, l: List[Int]): List[List[Int]] = {
      var solutions = List[List[Int]]()
  
      if (goal == 0 || l.isEmpty) {
        List(List())
        1
      }
  
      def checkPrice(sumList: List[Int], l: List[Int]): Int = {
        val sum = sumup(sumList)
        if (l.isEmpty) 0
        else if (goal == sum) {
          solutions ++= List(sumList)
          1
        } else if (sum > goal) checkPrice(sumList, l.tail)
        else if (sum < goal) checkPrice(l.head :: sumList, l) + checkPrice(sumList, l.tail)
        0
      }
      checkPrice(List(), l)
  
      solutions
  
    }
}

   