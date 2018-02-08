package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    println("test master merge!")
    println("merge branch into master")
    val aa = "33333"
    println(s"${aa}")
    Ok(views.html.index("Your new application is ready."))
  }

}