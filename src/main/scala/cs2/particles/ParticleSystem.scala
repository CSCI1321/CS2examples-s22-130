package cs2.particles

import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2
import scalafx.scene.image.Image
import scala.collection.mutable.Buffer

class ParticleSystem(protected var origin:Vec2) {
  protected var particles = Buffer[Particle]()

  def addParticle():Unit = {
    /*
    if(math.random() < 0.5) {
      particles ::= new RoundParticle(new Vec2(origin.x, origin.y), 
                     Vec2(math.random()-0.5, math.random()-0.5))
    } else {
      particles ::= new SquareParticle(origin.clone(), 
                     Vec2(math.random()-0.5, math.random()-0.5))
    }*/
    particles +:= new RainbowParticle(new Vec2(origin.x, origin.y), 
                     Vec2(math.random()-0.5, math.random()-0.5))
  }
  def display(g:GraphicsContext):Unit = {
    //println(particles.length)
    for(p <- particles) p.display(g)
  }
  def timeStep():Unit = {
    particles.foreach(_.timeStep())
    /*
    for(p <- particles) {
      if(p.isDead()) particles -= p
    }*/
    particles = particles.filterNot(_.isDead())
    println(particles.length)
  }
  def applyForce(f:Vec2):Unit = {
    for(p <- particles) p.applyForce(f)
  }

  def checkForEraser(er:Eraser):Unit = {
    particles = particles.filterNot(x => er.intersectParticle(x))
  }

}