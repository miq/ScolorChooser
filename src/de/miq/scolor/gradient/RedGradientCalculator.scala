package de.miq.scolor.gradient

import java.awt.Color

class RedGradientCalculator extends GradientCalculator {
  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    new Color((pos / width.asInstanceOf[Float] * 255).asInstanceOf[Int], baseColor.getGreen, baseColor.getBlue)
  }
  
  override def computeComponent(baseColor: Color) : Int = {
    baseColor.getRed
  }
  
  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    new Color(value, baseColor.getGreen, baseColor.getBlue)
  }
}
