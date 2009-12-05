package de.miq.scolor

import javax.swing.JColorChooser
import java.awt.Color
import javax.swing._
import javax.swing.colorchooser._

class ScolorChooser extends JColorChooser(Color.RED) {

//  setChooserPanels(Array(new ScalaColorChooserPanel))
  addChooserPanel(new ScalaColorChooserPanel)
  setPreviewPanel(new JPanel())
}
