// src/main/scala/Module/ForComp.scala
package Module

object forComp {
  /*Translate:
  *
  * val nums = List(List(0, 10000, 22, 3093, 5), List (-1, -2, 400), List())
  * nums.flatMap(lst => lst.filter(num => num > 0).map(number => number.toString.length))
  *
  * into a for composition
  */
  def main(args: Array[String]) {
    val nums = List(List(0, 10000, 22, 3093, 5), List (-1, -2, 400), List())
    println(nums.flatMap(lst => lst.filter(num => num > 0).map(number => number.toString.length)))

    val numLengths = for {
      lst <- nums
      num <- lst
      if num > 0
    } yield {
      num.toString.length
    }

    println(numLengths)
  }
}
