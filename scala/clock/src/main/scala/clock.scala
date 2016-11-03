class Clock(h: Int, m: Int) {
  lazy val hours = Math.floorMod(h + Math.floorDiv(m, 60), 24)
  lazy val minutes = Math.floorMod(m, 60)

  def + (that: Clock): Clock = Clock(hours + that.hours, minutes + that.minutes)
  def - (that: Clock): Clock = Clock(hours - that.hours, minutes - that.minutes)

  override def toString: String = f"$hours%02d:$minutes%02d"

  def canEqual(a: Any) = a.isInstanceOf[Clock]
  override def hashCode: Int = (41 * hours) + minutes
  override def equals(that: Any): Boolean = {
    that match {
      case that: Clock => that.canEqual(this) && this.minutes == that.minutes && this.hours == that.hours
      case _ => false
    }
  }
}

object Clock {
  def apply(hours: Int, minutes: Int): Clock = new Clock(hours, minutes)
  def apply(minutes: Int): Clock = new Clock(0, minutes)
}
