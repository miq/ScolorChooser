package de.miq.scolor.gradient

import java.awt.Color

class HueGradientCalculator extends GradientCalculator {
  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Color.getHSBColor(pos / width.asInstanceOf[Float], hsb(1), hsb(2))
  }
  
  def computeComponent(baseColor: Color) : Int = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Math.round(hsb(0) * 360)
  }
  
  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
	val hsb = new Array[Float](3)
	Color.RGBtoHSB(baseColor.getRed, baseColor.getGreen, baseColor.getBlue, hsb)
    Color.getHSBColor(value / 360f, hsb(1), hsb(2))
  }
}
