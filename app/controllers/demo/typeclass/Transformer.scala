package controllers.demo.typeclass

/**
  * Created by KelvinHuang on 17/12/16.
  */
trait Transformer[T, R]{
  def transform(t: T): R
}

object Transformer {

}
