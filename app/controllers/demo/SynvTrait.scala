package controllers.demo

/**
  * Created by KelvinHuang on 17/12/10.
  */
trait SynvTrait {
  def thread(body: => Unit): Thread = {
    val t = new Thread{
      override def run() = body
    }
    t.start()
    t
  }

}
