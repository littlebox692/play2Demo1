package controllers.demo

/**
  * Created by KelvinHuang on 17/10/24.
  */
object Demo2 {

  def main(args: Array[String]) {
//    val sumDemo = sum _
//    println(sumDemo(1,2,3) + "=========")
    val second: (Int) => Int = first(2)
    val second2 = curriedSum(2)_
    println(twice(_ +1, 5))


  }

  def sum(a: Int, b: Int, c: Int) = a + b + c

  def first(x: Int) = (y: Int) => x + y

  def twice(op: Double => Double, x: Double) = op(op(x))

  def curriedSum(x: Int)(y: Int) = x + y

}
