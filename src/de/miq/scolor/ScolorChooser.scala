package de.miq.scolor

import java.awt.Color
import javax.swing._

class ScolorChooser extends JColorChooser(Color.RED) {

  addChooserPanel(new ScalaColorChooserPanel)
  setPreviewPanel(new JPanel())
}
