package de.htw.fp.assignment6

import scala.collection.mutable.Stack

object coins_with_solutionexport extends App {

  def sumUp(l: List[Int]): Int = {
    if (l.isEmpty) 0
    else sumUp(l.tail) + l.head
  }

  def countPricePossibilities(goal: Int, coins: List[Int]): List[List[Int]] = {

    def checkPrice(sumList: List[Int], l: List[Int], solutions: List[List[Int]]): List[List[Int]] = {
      // we could use a sum:Int variable and thus avoid the sumUp method
      val sum = sumUp(sumList)

      if (l.isEmpty) solutions
      else if (goal == sum) sumList :: solutions
      else if (sum < goal) checkPrice(l.head :: sumList, l, solutions) ::: checkPrice(sumList, l.tail, solutions)
      else Nil

    }
    
    if (coins.isEmpty)
      List(List())
    else
      checkPrice(List(), coins, List[List[Int]]())
  }
}

   