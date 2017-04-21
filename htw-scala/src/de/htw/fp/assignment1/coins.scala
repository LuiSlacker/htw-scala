

package de.htw.fp.assignment1

object coins {
  
  def main(args: Array[String]){
    val coinDenominations: List[Int] = List(1, 2, 5) 
    println(countChange(3, coinDenominations))
  }
  
  def countChange(money: Int, coins: List[Int]): Int = {
    def reduce(money: Int, coins: List[Int], counter: Int): Int = {
      if(money == 0) counter + 1
      else if(money < 0 || coins.isEmpty) counter
      else reduce(money - coins.head, coins, counter) + reduce(money, coins.tail, counter)
   }

   if(money <= 0 || coins.isEmpty) 0
   else reduce(money, coins, 0)
  }
  
}