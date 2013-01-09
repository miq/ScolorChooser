package de.miq.scolor.gradient

import org.scalatest.FunSpec
import java.awt.Color
import org.scalatest.matchers.ShouldMatchers

class HueGradientCalculatorTest extends FunSpec with ShouldMatchers {

  describe("Hue component of hue gradient calculator") {
    it("should be 0 for red") {
      new HueGradientCalculator().computeComponent(Color.RED) should equal (0)
    }
    it("should be 120 for green") {
      new HueGradientCalculator().computeComponent(Color.GREEN) should equal (120)
    }
    it("should be 240 for blue") {
      new HueGradientCalculator().computeComponent(Color.BLUE) should equal (240)
    }
    it("should be 0 for gray, black and white") {
      new HueGradientCalculator().computeComponent(Color.GRAY) should equal (0)
      new HueGradientCalculator().computeComponent(Color.BLACK) should equal (0)
      new HueGradientCalculator().computeComponent(Color.WHITE) should equal (0)
    }
  }
}
