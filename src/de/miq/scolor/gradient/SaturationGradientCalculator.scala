package de.miq.scolor.gradient

import java.awt.Color

class SaturationGradientCalculator extends GradientCalculator {
  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Color.getHSBColor(hsb(0), pos / width.asInstanceOf[Float], hsb(2))
  }

  def computeComponent(baseColor: Color) : Int = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Math.round(hsb(1) * 100)
  }

  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Color.getHSBColor(hsb(0), value / 100f, hsb(2))
  }
}
