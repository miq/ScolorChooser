package de.miq.scolor

import java.applet._
import java.awt._

object ScolorChooserApplet extends Applet {

  override def init = {
    add(new ScolorChooser())
  }
}
