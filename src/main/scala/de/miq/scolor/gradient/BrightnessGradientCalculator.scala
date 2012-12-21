package de.miq.scolor.gradient

import java.awt.Color

class BrightnessGradientCalculator extends HSBCalculator {
  override val componentIndex = 2
  override val componentRange = 100f

  override def computeColor(baseColor: Color, pos: Int, width: Int) : Color = {
    val hsb = getComponents(baseColor)
    Color.getHSBColor(hsb(0), hsb(1), pos / width.asInstanceOf[Float])
  }

  override def computeNewBaseColor(baseColor: Color, value: Int) : Color = {
    val hsb = getComponents(baseColor)
    Color.getHSBColor(hsb(0), hsb(1), value / componentRange)
  }
}
