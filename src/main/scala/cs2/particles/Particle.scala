package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class Particle(var pos:Vec2, var vel:Vec2) {

  def display(g:GraphicsContext):Unit = {
    g.fillOval(pos.x,pos.y, 40,40)
  }
  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(f:Vec2):Unit = {
    vel += f
  }

}


