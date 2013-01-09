package de.miq.scolor.gradient

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import java.awt.Color

class SaturationGradientCalculatorTest extends FunSpec with ShouldMatchers {

  describe("Saturation component of saturation gradient calculator") {
    it("should be 100 for fully saturated colors") {
      new SaturationGradientCalculator().computeComponent(Color.GREEN) should be (100)
      new SaturationGradientCalculator().computeComponent(Color.RED) should be (100)
      new SaturationGradientCalculator().computeComponent(Color.YELLOW) should be (100)
      new SaturationGradientCalculator().computeComponent(Color.ORANGE) should be (100)
    }
    it("should be 0 for all shades of gray including black and white") {
      new SaturationGradientCalculator().computeComponent(Color.WHITE) should be (0)
      new SaturationGradientCalculator().computeComponent(Color.LIGHT_GRAY) should be (0)
      new SaturationGradientCalculator().computeComponent(Color.GRAY) should be (0)
      new SaturationGradientCalculator().computeComponent(Color.BLACK) should be (0)
    }
    it("should have the correct in between values for pastels etc.") {
      new SaturationGradientCalculator().computeComponent(new Color(255, 100, 100)) should be (61)
      new SaturationGradientCalculator().computeComponent(new Color(100, 100, 255)) should be (61)
      new SaturationGradientCalculator().computeComponent(new Color(200, 200, 255)) should be (22)
    }
  }

}
