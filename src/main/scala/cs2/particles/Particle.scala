package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

abstract class Particle(protected var pos:Vec2, protected var vel:Vec2) {

  //Abstract display method
  def display(g:GraphicsContext):Unit

  //Concrete methods
  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(f:Vec2):Unit = {
    vel += f
  }

}


