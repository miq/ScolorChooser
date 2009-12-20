package de.miq.scolor

import javax.swing._
import java.awt.Color
import net.miginfocom.swing.MigLayout

class HexColorDisplay extends JPanel(new MigLayout("insets 0")) {
  val label = new JLabel("HTML-Notation:")
  add(label)
  val hexField = new JTextField()
  add(hexField, "width 100%")
}
