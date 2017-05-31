package de.htw.fp.assignment5

import scala.annotation.tailrec

/**
 * This class represents a mathematical fraction and provides a bunch of utility methods to work with
 */
case class Fraction(numerator: Int, denominator: Int) {
  
  /** Calculates the greatest common divisor for a given Fraction */
  def gcd(frac: Fraction): Int = {
    if (frac.denominator == 0) frac.numerator.abs
    else gcd(Fraction(frac.denominator, frac.numerator % frac.denominator))
  }
  
  /** Calculates the least common multiple for two given integers */
  def lcm(a: Int, b: Int): Int = (a * b).abs / gcd(Fraction(a, b))
  
  /** Negates a given fraction */
  def negate(): Fraction = Fraction(-numerator, denominator)
  
  /** Returns the reciprocal of a given fraction */
  def inverse(): Fraction = Fraction(denominator, numerator)
  
  /** Returns the cancelled version of a given fraction */
  def cancel(): Fraction = Fraction(numerator / gcd(this), denominator / gcd(this))
  
  def multiply(that: Fraction): Fraction = Fraction(this.numerator * that.numerator, this.denominator * that.denominator).cancel()
  def divide(that: Fraction): Fraction = multiply(that.inverse()).cancel()
  def add(that: Fraction): Fraction = {
    val lcmVal: Int = lcm(denominator, that.denominator)
    val fac1 = lcmVal / denominator
    val fac2 = lcmVal / that.denominator
    Fraction(fac1 * numerator + fac2 * that.numerator, lcmVal).cancel()
  }
  def substract(that: Fraction): Fraction = add(that.negate())  
  
  /**
   * Checks whether two cancelled Fractions are the same
   * TODO is it possible to use super equals method to structurally compare the Fractions?
   */
  override def equals(that: Any) = that match {
    case frac: Fraction => frac.cancel().numerator == cancel().numerator && frac.cancel().denominator == cancel().denominator 
    case _ => false
  }
  
  override def toString() = "(" + numerator + " / " + denominator + ")"
  
}
