package de.htw.fp.assignment6

import scala.collection.mutable.Stack

object coins_with_solutionexport extends App {
  //def münzStückelungen (werte: List[Int], betrag: Int): List[List[Int]]

  def countPricePossibilities(goal: Int, l: List[Int]): List[List[Int]] = {
    var solutions = List[List[Int]]()
    var stack = Stack[Int]()

    //    println(stack.dropRight(1))

    def checkPrice(sum: Int, l: List[Int]): Int =
      if (goal == 0) 1
      else if (l.isEmpty) 0
      else if (goal == sum) 1
      else if (sum > goal) checkPrice(sum, l.tail)
      else if (sum < goal) checkPrice(sum + l.head, l) + checkPrice(sum, l.tail)
      else 0

    //
    //    def checkPrice(sum: Int, l: List[Int]): Int =
    //      if (goal == sum) {
    //        println("(goal == sum) - ")
    //        1
    //      } else if (l.isEmpty) {
    //        println("(l.isEmpty) - ")
    //        0
    //      } else if (l.head + sum == goal) {
    //
    //        print("(l.head + sum == goal) - ")
    //        stack.push(l.head)
    //        solutions ++= List(stack.toList)
    //        println(stack)
    //        stack = stack.dropRight(1)
    //        println(stack)
    //        //        stack = Stack()
    //        1 + checkPrice(sum, l.tail)
    //      } else if (l.head + sum > goal) {
    //        print("(l.head + sum > goal) - ")
    //        println(stack)
    //        checkPrice(sum, l.tail)
    //      } else if (l.head + sum < goal) {
    //        print("(l.head + sum < goal) - ")
    //        println(stack)
    //        stack.push(l.head)
    //        //        stack.dropRight(1)
    //        checkPrice(sum + l.head, l) + checkPrice(sum, l.tail)
    //      } else 0
    //    def checkPrice(sum: Int, l: List[Int]): Int =
    //      if (goal == sum) {
    //        stack.push(l.head)
    //        print("found - ")
    //        println(stack)
    //        solutions ++= List(stack.toList)
    //        1
    //      } else if (l.isEmpty) {
    //        //        stack.dropRight(1)
    //        print("end - ")
    //        println(stack)
    //        0
    //      } else if (l.head + sum == goal) {
    //        //        stack.push(l.head)
    //        //        print("found in next - ")
    //        //
    //        //        println(stack.toList)
    //        checkPrice(l.head + sum, l)
    //      } else if (l.head + sum > goal) checkPrice(sum, l.tail)
    //      else if (l.head + sum < goal) checkPrice(sum + l.head, l) + checkPrice(sum, l.tail)
    //      else {
    //        print("iter - ")
    //        0
    //      }

    println(checkPrice(0, l))

    solutions
  }

}