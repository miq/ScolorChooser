package de.miq.scolor.gradient

import org.scalatest.FunSpec
import java.awt.Color

class HueGradientCalculatorTest extends FunSpec {

  describe("Hue component of hue gradient calculator") {
    it("should be 0 for red") {
      assert(0 === new HueGradientCalculator().computeComponent(Color.RED))
    }
    it("should be 120 for green") {
      assert(120 === new HueGradientCalculator().computeComponent(Color.GREEN))
    }
    it("should be 240 for blue") {
      assert(240 === new HueGradientCalculator().computeComponent(Color.BLUE))
    }
    it("should be 0 for gray, black and white") {
      assert(0 === new HueGradientCalculator().computeComponent(Color.GRAY))
      assert(0 === new HueGradientCalculator().computeComponent(Color.BLACK))
      assert(0 === new HueGradientCalculator().computeComponent(Color.WHITE))
    }
  }
}
