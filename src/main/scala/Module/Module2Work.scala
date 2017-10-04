// src/main/scala/Module/Module2Work.scala
package Module

object Add {
  def addition(a: Int, b: Int): Int = {
    return a + b
  }

  val currAdd = (addition _).curried

  val adding = currAdd(1)

  val subtracting = currAdd(-1)

  def mapOverList(ints: List[Int], f: Int => Int): List[Int] = {
    @scala.annotation.tailrec
    def ListRec(ints: List[Int], accum: List[Int]): List[Int] = ints match {
      case Nil => accum
      case head :: tail => ListRec(tail, accum :+ f(head))
    }
    ListRec(ints, Nil)
  }

  def main(args: Array[String]) {
    println(addition(3,4))
    println(currAdd(3)(4))
    println(adding(2))
    println(subtracting(2))

    val nums = List(1,2,3,4,5)

    val acceding = mapOverList(nums, adding)
    val decending = mapOverList(nums, subtracting)

    println(acceding)
    println(decending)
  }
}
