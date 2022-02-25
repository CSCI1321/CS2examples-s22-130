package cs2.particles

import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2

class SquareParticle(p:Vec2,v:Vec2) extends Particle(p,v) {

  override def display(g:GraphicsContext):Unit = {
    g.fillRect(pos.x,pos.y, 40,40)
  }

}