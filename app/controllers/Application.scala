package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    println("just for test branch")
    Ok
  }

}