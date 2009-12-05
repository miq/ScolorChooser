package de.miq.scolor

import java.awt.Color
import javax.swing._
import javax.swing.colorchooser._
import javax.swing.event._
import net.miginfocom.swing.MigLayout
import scala.swing.Swing._

import de.miq.scolor.gradient._

class ScalaColorChooserPanel extends AbstractColorChooserPanel {

  val colorControls = List(
		  new ColorComponentControl("H", new HueGradientCalculator(), 360, colorChangedCallback),
		  new ColorComponentControl("S", new SaturationGradientCalculator(), 100, colorChangedCallback),
		  new ColorComponentControl("B", new BrightnessGradientCalculator(), 100, colorChangedCallback),
		  new ColorComponentControl("R", new RedGradientCalculator(), 255, colorChangedCallback),
		  new ColorComponentControl("G", new GreenGradientCalculator(), 255, colorChangedCallback),  
		  new ColorComponentControl("B", new BlueGradientCalculator(), 255, colorChangedCallback))
  val colorPanel = new JPanel
  
  override def getLargeDisplayIcon : Icon = {
    return null
  }
  
  override def getSmallDisplayIcon : Icon = {
    return null
  }
  
  override def getDisplayName : String = {
    return "Scala Mighty"
  }
  
  def colorChangedCallback(newColor: Color) : Unit = {
    colorControls.foreach(cc => cc.color = newColor)
    colorPanel.setBackground(newColor)
  }
  
  override def buildChooser = {
    setLayout(new MigLayout())
    colorPanel.setMinimumSize(100, 100)
    add(colorPanel, "spany, grow")
    colorControls.foreach(cc => add(cc, "wrap"))
    colorChangedCallback(Color.GREEN)
  }
  
  override def updateChooser = {
    
  }
}
