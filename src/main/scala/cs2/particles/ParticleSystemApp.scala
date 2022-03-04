package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.image.Image

object ParticleSystemApp extends JFXApp with Rainbowness {
  val img = new Image(getClass().getResource("/images/Star.png").toString)
  
  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(800,800) {
      val canvas = new Canvas(width.value, height.value)
      content = canvas
      val g = canvas.graphicsContext2D

      var pslist = List[ParticleSystem]() 
      
      canvas.onMouseClicked = (e:MouseEvent) => {
        pslist ::= new ParticleSystem(Vec2(e.x,e.y))
      }

      val timer = AnimationTimer(t => {
        g.setFill(stepColor())
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.rgb(40,80,120, 0.2))
        for(ps <- pslist) {
          ps.display(g)
          ps.timeStep()
          ps.addParticle()
          ps.applyForce(Vec2(0,0.005))
        }
      })
      timer.start
      


    }
  }
}