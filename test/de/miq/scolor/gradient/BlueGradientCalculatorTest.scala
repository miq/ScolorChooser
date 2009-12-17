package de.miq.scolor.gradient

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import org.scalatest.junit.ShouldMatchersForJUnit
import java.awt._

class BlueGradientCalculatorTest extends AssertionsForJUnit with ShouldMatchersForJUnit {
  
  @Test def testComputeComponent() {
	assert(0 == new BlueGradientCalculator().computeComponent(Color.BLACK))
	assert(255 == new BlueGradientCalculator().computeComponent(Color.BLUE))
	assert(56 == new BlueGradientCalculator().computeComponent(new Color(230, 9, 56)))
  }
  
  @Test def testComputeColor() {
    assert(new Color(200, 100, 0) === new BlueGradientCalculator().computeColor(new Color(200, 100, 78), 0, 400))
    assert(new Color(0, 100, 127) === new BlueGradientCalculator().computeColor(new Color(0, 100, 78), 200, 400))
    new BlueGradientCalculator().computeColor(new Color(200, 175, 78), 400, 400) should be (new Color(200, 175, 255))
  }
  
  @Test def testIllegalBaseColorComponent() {
    intercept[IllegalArgumentException] {
      new BlueGradientCalculator().computeNewBaseColor(Color.RED, -1)
    }
    intercept[IllegalArgumentException] {
    	new BlueGradientCalculator().computeNewBaseColor(Color.CYAN, 256)
    }
  }

}
