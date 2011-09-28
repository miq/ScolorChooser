package de.miq.scolor

import javax.swing._
import javax.swing.colorchooser._
import net.miginfocom.swing.MigLayout

import de.miq.scolor.gradient._
import java.awt.{Dimension, Color}

class ScalaColorChooserPanel extends AbstractColorChooserPanel {
  private val colorControls = List(
    new ColorComponentControl("H", new HueGradientCalculator(), 359, colorChangedCallback),
    new ColorComponentControl("S", new SaturationGradientCalculator(), 100, colorChangedCallback),
    new ColorComponentControl("B", new BrightnessGradientCalculator(), 100, colorChangedCallback),
    new ColorComponentControl("R", new RedGradientCalculator(), 255, colorChangedCallback),
    new ColorComponentControl("G", new GreenGradientCalculator(), 255, colorChangedCallback),
    new ColorComponentControl("B", new BlueGradientCalculator(), 255, colorChangedCallback))
  private val hexDisplay = new HexColorDisplay()
  private val colorPanel = new JPanel

  override def getLargeDisplayIcon: Icon = {
    null
  }

  override def getSmallDisplayIcon: Icon = {
    null
  }

  override def getDisplayName: String = {
    "Scala Mighty"
  }

  private def colorChangedCallback(newColor: Color) {
    colorControls.foreach(cc => cc.color = newColor)
    colorPanel.setBackground(newColor)
    hexDisplay.setColor(newColor)
  }

  override def buildChooser() {
    setLayout(new MigLayout())
    colorPanel.setMinimumSize(new Dimension(100, 100))
    add(colorPanel, "spany, height 60%, aligny center")
    colorControls.foreach(cc => {
      add(cc.labelRadio)
      add(cc.slider)
      add(cc.spinner, "wrap")
    })
    add(hexDisplay, "spanx, growx")
    colorChangedCallback(Color.GREEN)
  }

  override def updateChooser() {}
}
