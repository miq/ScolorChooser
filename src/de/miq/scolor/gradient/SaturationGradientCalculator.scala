package de.miq.scolor.gradient

import java.awt.Color

class SaturationGradientCalculator extends HSBCalculator {
  override val componentIndex = 1
  override val componentRange = 100

  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    val hsb = getComponents(baseColor)
    Color.getHSBColor(hsb(0), pos / width.asInstanceOf[Float], hsb(2))
  }

  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    val hsb = getComponents(baseColor)
    Color.getHSBColor(hsb(0), value / componentRange.asInstanceOf[Float], hsb(2))
  }
}
