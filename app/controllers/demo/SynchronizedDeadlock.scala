package controllers.demo

import com.typesafe.scalalogging.StrictLogging

/**
  * Created by KelvinHuang on 17/12/10.
  */
object SynchronizedDeadlock extends App with StrictLogging with SynvTrait {
  def send(a: Account, b: Account, n: Int) = a.synchronized{
    b.synchronized{
      a.money -= n
      b.money += n
    }
  }

  val a = Account("jack", 1000)
  val b = Account("jill", 1000)
  val t1 = thread{
    for (i <- 0 until 100) {
      send(a, b, 1)
    }
  }
  val t2 = thread{
    for (i <- 0 until 100) {
      send(b, a, 1)
    }
  }

  t1.join()
  t2.join()
  logger.info(s"a = ${a.money}, b = ${b.money}")
}
