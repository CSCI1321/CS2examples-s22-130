package cs2.graphics

import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(800,600) {
      val canvas = new Canvas(800,600)
      content =  canvas
      val g = canvas.graphicsContext2D

      g.strokeLine(0,0, 400,200)
      g.strokeRect(100,200, 300,200)
      g.fillOval(100,200, 300,200)

    }
  }
}