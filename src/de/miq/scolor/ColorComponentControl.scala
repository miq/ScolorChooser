package de.miq.scolor

import javax.swing._
import javax.swing.event.{ChangeEvent,ChangeListener}
import java.awt._
import java.awt.event.{ActionEvent}
import net.miginfocom.swing.MigLayout
import scala.swing.Swing._

import de.miq.scolor.gradient._

class ColorComponentControl(label: String, gradientCalculator: GradientCalculator, maxValue: Int, colorChanged: (Color) => Unit) {
  val notifier = new NotifyingChangeListener
  val labelRadio = new JRadioButton(label)
  val slider = new GradientSlider(gradientCalculator, 0, maxValue, 0)
  val spinner = new JSpinner(new SpinnerNumberModel(0, 0, maxValue, 1))
  slider.addChangeListener(new ChangeListener() {
	override def stateChanged(e: ChangeEvent) {
	  spinner.setValue(slider.getValue)
	}
  })
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


