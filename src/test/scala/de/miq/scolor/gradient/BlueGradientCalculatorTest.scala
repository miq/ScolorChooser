package de.miq.scolor.gradient

import java.awt._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BlueGradientCalculatorTest extends FunSuite with ShouldMatchers {

  test ("compute component") {
    assert(0 == new BlueGradientCalculator().computeComponent(Color.BLACK))
    assert(255 == new BlueGradientCalculator().computeComponent(Color.BLUE))
    assert(56 == new BlueGradientCalculator().computeComponent(new Color(230, 9, 56)))
  }

  test ("compute color") {
    assert(new Color(200, 100, 0) === new BlueGradientCalculator().computeColor(new Color(200, 100, 78), 0, 400))
    assert(new Color(0, 100, 127) === new BlueGradientCalculator().computeColor(new Color(0, 100, 78), 200, 400))
    new BlueGradientCalculator().computeColor(new Color(200, 175, 78), 400, 400) should be (new Color(200, 175, 255))
  }

  test ("base color component out of range") {
    intercept[IllegalArgumentException] {
      new BlueGradientCalculator().computeNewBaseColor(Color.RED, -1)
    }
    intercept[IllegalArgumentException] {
      new BlueGradientCalculator().computeNewBaseColor(Color.CYAN, 256)
    }
  }
}
