package de.miq.scolor

import java.awt.{Graphics, Graphics2D}

object SwingPredef {

  implicit def graphicsToGraphics2D(g: Graphics): Graphics2D = g.asInstanceOf[Graphics2D]
}
