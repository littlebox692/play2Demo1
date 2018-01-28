package controllers.demo.functional

/**
  * Created by KelvinHuang on 17/12/17.
  */
case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge ={
    if (other.cc == other) {
      Charge(cc, amount + other.amount)
    }else {
      throw new Exception("")
    }
  }

  def factorial(n: Int) = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if(n <= 0) acc else go(n - 1, n * acc)
    }
    go(n, 1)
  }

  def curry[A, B, C](f: (A, B) => C): A => B => C = {
    (a: A) => (b: B) => f(a, b)
  }

  def curryDemo(a: String, b: Int) = {
    if (b > 2) true else false
  }

  def testDemo() = {
    val demo: (String) => (Int) => Boolean = curry(curryDemo)
    val demo1: (Int) => Boolean = demo("first")
    val demo2: Boolean = demo1(123)
    val demo3: Boolean = demo("second")(1234)
    //====================
    val undemo: (String, Int) => Boolean = uncurry(demo)
    val undemo1: Boolean = undemo("", 123)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }
}
