package de.miq.scolor

import javax.swing._
import java.awt.EventQueue

object ScolorChooserMain {

  def buildMainWindow : JFrame = {
    val mainWindow = new JFrame("Scala Custom Color Chooser")
    mainWindow.setSize(500, 300)
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    mainWindow.getContentPane.add(new ScolorChooser())
    mainWindow
  }

  def main(args : Array[String]) {
    // XXX: somehow this does not work with implicit conversion from block to runnable...
    EventQueue.invokeLater(new Runnable() {
      override def run() {
        buildMainWindow setVisible true
      }
    })
  }
}
