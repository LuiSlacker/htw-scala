package de.htw.fp.assignment13


case class Cell(free: Boolean, start: Boolean)

case class Position(x: Int, y: Int) {
  def _x = x
  def _y = y
  def top = Position(x, y - 1)
  def bottom = Position(x, y + 1)
  def left = Position(x - 1, y)
  def right = Position(x + 1, y)

  override def toString = "(" + x + ", " + y + ")"
}

