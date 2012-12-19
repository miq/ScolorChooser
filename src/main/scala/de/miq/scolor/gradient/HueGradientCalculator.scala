package de.miq.scolor.gradient

import java.awt.Color

class HueGradientCalculator extends HSBCalculator {
  override val componentIndex = 0
  override val componentRange = 360

  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    val hsb = getComponents(baseColor)
    Color.getHSBColor(pos / width.asInstanceOf[Float], hsb(1), hsb(2))
  }

  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    val hsb = getComponents(baseColor)
    Color.getHSBColor(value / componentRange.asInstanceOf[Float], hsb(1), hsb(2))
  }
}
