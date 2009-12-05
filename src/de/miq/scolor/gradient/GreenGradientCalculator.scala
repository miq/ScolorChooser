package de.miq.scolor.gradient

import java.awt.Color

class GreenGradientCalculator extends GradientCalculator {
  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    new Color(baseColor.getRed, (pos / width.asInstanceOf[Float] * 255).asInstanceOf[Int], baseColor.getBlue)
  }
  
  override def computeComponent(baseColor: Color) : Int = {
    baseColor.getGreen
  }
  
  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    new Color(baseColor.getRed, value, baseColor.getBlue)
  }

}
