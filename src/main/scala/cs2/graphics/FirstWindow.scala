package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import scalafx.animation.AnimationTimer
import scalafx.scene.image.Image

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(800,600) {
      val canvas = new Canvas(800,600)
      content =  canvas
      val g = canvas.graphicsContext2D

      g.strokeLine(0,0, 400,200)
      g.setStroke(Color.DarkOrchid)
      g.strokeRect(100,200, 300,200)
      g.fillOval(100,200, 300,200)

      canvas.onKeyPressed = (e:KeyEvent) => {
        if(e.code == KeyCode.Q) {
          g.setFill(Color.White)
          g.fillRect(0,0, width.value,height.value)
        } else {
          g.setLineWidth(2)
          for(x <- 0 to width.value.toInt) {
            g.setStroke(Color.rgb((x/width.value*255).toInt, 0,0))
            if(e.code == KeyCode.Space) {
              g.setStroke(Color.rgb((math.random()*255).toInt,
                                    (math.random()*255).toInt,
                                    (math.random()*255).toInt))
            }
            g.strokeLine(x,0, x,height.value)
          }
        }
      }
      canvas.requestFocus()

      var xball = 200.0
      var yball = 100.0
      var rball = 50.0
      var vball = 0.05
      
      val path = getClass().getResource("/images/Star.png")
      val img = new Image(path.toString)

      val timer = AnimationTimer (t => {
        g.setFill(Color.Black)
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.DarkOrange)
        //g.fillOval(xball,yball, rball*2,rball*2)
        g.drawImage(img, xball,yball, rball*2,rball*2)
        yball += vball
        if(yball+rball*2 > height.value || yball <= 0) {
          vball = -1 * vball
        }
      })
      timer.start


    }
  }
}