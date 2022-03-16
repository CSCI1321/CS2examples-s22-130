package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class ImageParticle(p:Vec2,v:Vec2, val img:Image) extends Particle(p,v) {
  private var lifetime = 1.0

  override def isDead(): Boolean = { lifetime < 0.0 }

  def display(g:GraphicsContext):Unit = {
    g.globalAlpha = lifetime  
    g.drawImage(ParticleSystemApp.img, pos.x,pos.y)
    lifetime -= 0.002
    g.globalAlpha = 1
  }
}