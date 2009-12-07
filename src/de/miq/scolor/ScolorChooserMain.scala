package de.miq.scolor

import javax.swing._

object ScolorChooserMain {
  
  def buildMainWindow : JFrame = {
    val mainWindow = new JFrame("Scala Custom Color Chooser")
    mainWindow.setSize(500, 300)
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    mainWindow.getContentPane().add(new ScolorChooser());
    return mainWindow
  }
  
  def main(args : Array[String]) : Unit = {
    buildMainWindow setVisible true
    return 0
  }
}
