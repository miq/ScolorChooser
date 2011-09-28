package de.miq.scolor

import javax.swing._
import java.awt.Color
import net.miginfocom.swing.MigLayout

class HexColorDisplay extends JPanel(new MigLayout("insets 0")) {
  val label = new JLabel("HTML-Notation:")
  add(label)
  val hexField = new JTextField(6)
  hexField.setMaximumSize(hexField.getPreferredSize)
  hexField.setEditable(false)
  add(hexField, "width 100%")

  def setColor(c: Color) {
    hexField.setText(leadingZeroHex(c.getRed) + leadingZeroHex(c.getGreen) + leadingZeroHex(c.getBlue))
  }

  private def leadingZeroHex(i: Int) : String = {
    if (i < 16) {
      "0" + i.toHexString
    } else {
      i.toHexString
    }
  }
}
