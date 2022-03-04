package cs2.particles

import cs2.util.Vec2
import scalafx.scene.image.Image

class ImageParticleSystem(o:Vec2, val img:Image) extends ParticleSystem(o) {

  override def addParticle(): Unit = {
    particles ::= new ImageParticle(origin.clone(),
                      Vec2(math.random()-0.5, math.random()-0.5), img)
  }

}