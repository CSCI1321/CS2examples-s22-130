package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class ImageParticle(p:Vec2,v:Vec2, val img:Image) extends Particle(p,v) {
  def display(g:GraphicsContext):Unit = {  
    g.drawImage(ParticleSystemApp.img, pos.x,pos.y)
  }
}