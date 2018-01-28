package controllers.demo

import com.sun.tools.javah.Gen
import play.api.libs.functional.Monoid

import scala.sys.Prop

/**
  * Created by KelvinHuang on 17/11/27.
  */
object TestExpr {
  def main(args: Array[String]) {
    val words = List(1, 2, 3, 4)
    val s = words.foldLeft(1)((a1, a2) => a1 - a2)
    val s1 = words.foldRight(1)((a1, a2) => a1 - a2)
    println(s1)
    print(s)
  }

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))  => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  val stringMonoid = new Monoid[String] {
    override def append(a1: String, a2: String): String = a1 + a2

    override def identity: String = ""
  }

  def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
    override def identity: Option[A] = None

    override def append(a1: Option[A], a2: Option[A]): Option[A] = a1 orElse(a2)
  }

  def endoMonoid[A]: Monoid[A => A] = new Monoid[(A) => A] {
    override def identity: A => A = {a => a}

    override def append(a1: (A) => A, a2: (A) => A): (A) => A = {
      a1 compose(a2)
    }
  }



}
