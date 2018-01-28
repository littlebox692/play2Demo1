package controllers.demo

import com.typesafe.scalalogging.StrictLogging


/**
  * Created by KelvinHuang on 17/12/10.
  */
object SynchronizedNesting extends App with StrictLogging{
  import scala.collection._

  private var transfers = mutable.ArrayBuffer[String]()
  def logTransfer(name: String, n: Int) = transfers.synchronized{
    transfers += s"transfer to account '$name' = $n"
  }

  def add(account: Account, n: Int) = account.synchronized{
    account.money += n
    if (n > 10) logTransfer(account.name, n)
  }

  val jane = new Account("jane", 100)
  val john = new Account("john", 100)
  val t1 = thread(add(jane, 5))
  val t2 = thread(add(john, 50))
  val t3 = thread(add(jane, 70))
  t1.join()
  t2.join()
  t3.join()
  logger.info(s"--- transfers --- \n$transfers")
//====================================================
  def thread(body: => Unit): Thread = {
    val t = new Thread{
      override def run() = body
    }
    t.start()
    t
  }

}

case class Account(val name: String, var money: Int)

