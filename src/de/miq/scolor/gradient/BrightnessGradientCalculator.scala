package de.miq.scolor.gradient

import java.awt.Color

class BrightnessGradientCalculator extends GradientCalculator {
  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Color.getHSBColor(hsb(0), hsb(1), pos / width.asInstanceOf[Float])
  }

  def computeComponent(baseColor: Color) : Int = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Math.round(hsb(2) * 100)
  }

  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Color.getHSBColor(hsb(0), hsb(1), value / 100f)
  }
}
