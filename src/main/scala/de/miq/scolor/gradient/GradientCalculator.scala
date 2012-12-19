package de.miq.scolor.gradient

import java.awt.Color

abstract class GradientCalculator {

  def computeColor(baseColor: Color, pos: Int, width: Int) : Color
  
  def computeComponent(baseColor: Color) : Int
  
  def computeNewBaseColor(baseColor: Color, value: Int) : Color
}
