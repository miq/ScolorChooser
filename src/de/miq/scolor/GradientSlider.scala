package de.miq.scolor

import javax.swing.plaf._
import javax.swing.plaf.basic._
import java.awt._
import javax.swing._

import de.miq.scolor.gradient.GradientCalculator

class GradientSlider(gradientCalculator: GradientCalculator, v: Int, min: Int, max: Int) extends JSlider(SwingConstants.HORIZONTAL, v, min, max) {
  private[this] var bc: Color = Color.WHITE

  setUI(new GradientSliderUI(this, gradientCalculator))
  setValue(gradientCalculator.computeComponent(baseColor))
  
  def baseColor = {
    bc
  }
  
  def baseColor_= (c: Color) {
    bc = c
    setValue(gradientCalculator.computeComponent(baseColor))
    repaint()
  }
}

class GradientSliderUI(slider: GradientSlider, gradientCalculator : GradientCalculator) extends BasicSliderUI(slider) {
  override def paintThumb(g: Graphics) = {
	val g2d = g.create.asInstanceOf[Graphics2D]
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
	g2d.translate(thumbRect.x, thumbRect.y);
	val arrowHeight = thumbRect.height / 2 - 2
	val topTriangle = new Polygon()
	topTriangle.addPoint(0, 1)
	topTriangle.addPoint(thumbRect.width / 2, arrowHeight)
	topTriangle.addPoint(thumbRect.width - 1, 1)
	g2d.setColor(Color.BLACK)
	g2d.fillPolygon(topTriangle)
	val bottomTriangle = new Polygon
	bottomTriangle.addPoint(0, thumbRect.height - 1)
	bottomTriangle.addPoint(thumbRect.width - 1, thumbRect.height - 1)
	bottomTriangle.addPoint(thumbRect.width / 2, thumbRect.height - arrowHeight)
	g2d.setColor(Color.WHITE)
	g2d.fillPolygon(bottomTriangle)
  }
  
  override def getThumbSize() : Dimension = {
    return new Dimension(13, 18)
  }
  
  override def paintTrack(g: Graphics) = {
    super.paintTrack(g)
	val g2d = g.create.asInstanceOf[Graphics2D]
	g2d.translate(trackRect.x, trackRect.y);
    g.setColor(Color.GREEN)
    val gradientWidth = trackRect.width - 2
    for (x <- 0 to gradientWidth) {
      g.setColor(gradientCalculator.computeColor(slider.baseColor, x, gradientWidth))
      g.drawLine(x + getThumbSize.width / 2, 2, x + getThumbSize.width / 2, trackRect.height - 4)
    }
  }
}
