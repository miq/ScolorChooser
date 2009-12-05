package de.miq.scolor

import javax.swing._
import javax.swing.event.{ChangeEvent,ChangeListener}
import java.awt._
import java.awt.event.{ActionEvent}
import net.miginfocom.swing.MigLayout
import scala.swing.Swing._

import de.miq.scolor.gradient._

class ColorComponentControl(label: String, gradientCalculator: GradientCalculator, maxValue: Int, colorChanged: (Color) => Unit)
	extends JPanel(new MigLayout("insets 0")){

  val notifier = new NotifyingChangeListener
  
  add(new JRadioButton(label))
  val slider = new GradientSlider(gradientCalculator, 0, maxValue, 0)
  add(slider)
  val spinner = new JSpinner(new SpinnerNumberModel(0, 0, maxValue, 1))
  slider.addChangeListener(new ChangeListener() {
	override def stateChanged(e: ChangeEvent) {
	  spinner.setValue(slider.getValue)
	}
  })
  add(spinner)
  slider.baseColor = Color.WHITE
  spinner.setValue(gradientCalculator.computeComponent(slider.baseColor))
  spinner.addChangeListener(new ChangeListener() {
	override def stateChanged(e: ChangeEvent) {
	  slider.setValue(spinner.getValue.asInstanceOf[Int])
	}
  })
  slider.addChangeListener(notifier)
 
  def color: Color = {
	slider.baseColor
  }
 
  def color_= (c: Color) {
	slider.removeChangeListener(notifier)
	slider.baseColor = c
	slider.addChangeListener(notifier)
  }
 
  def notifyColorChanged(value: Int) = {
	val newColor = gradientCalculator.computeNewBaseColor(color, value)
	colorChanged(newColor)
  }

  class NotifyingChangeListener extends ChangeListener {
	override def stateChanged(e: ChangeEvent) {
	  notifyColorChanged(slider.getValue)
	}
  }
}


