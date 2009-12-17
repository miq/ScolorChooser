package de.miq.scolor.gradient

import java.awt.Color

class BlueGradientCalculator extends GradientCalculator {
  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    new Color(baseColor.getRed, baseColor.getGreen, (pos / width.asInstanceOf[Float] * 255).asInstanceOf[Int])
  }
  
  override def computeComponent(baseColor: Color) : Int = {
    baseColor.getBlue
  }
  
  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    require(value >= 0 && value < 256)
    new Color(baseColor.getRed, baseColor.getGreen, value)
  }
}
