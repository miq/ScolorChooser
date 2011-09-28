package de.miq.scolor.gradient

import java.awt.Color


trait HSBCalculator extends GradientCalculator {
  protected def componentIndex: Int
  protected def componentRange: Int

  def computeComponent(baseColor: Color) : Int = {
    math.round(getComponents(baseColor)(componentIndex) * componentRange)
  }

  protected final def getComponents(c: Color) : Array[Float] = {
    val hsb = new Array[Float](3)
    Color.RGBtoHSB(c.getRed, c.getGreen, c.getBlue, hsb)
  }
}
