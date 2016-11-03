case class Clock(h: Int, m: Int) {

  def this(minutes: Int) = this(0, minutes)

  def hours: Int = Math.floorMod(h + Math.floorDiv(m, 60), 24)

  def minutes: Int = Math.floorMod(m, 60)

  def + (that: Clock): Clock = Clock(hours + that.hours, minutes + that.minutes)

  def - (that: Clock): Clock = Clock(hours - that.hours, minutes - that.minutes)

  override def toString: String = {
    f"$hours%02d:$minutes%02d"
  }

  def canEqual(a: Any) = a.isInstanceOf[Clock]

  override def equals(that: Any): Boolean = {
    that match {
      case that: Clock => that.canEqual(this) && this.minutes == that.minutes && this.hours == that.hours
      case _ => false
    }
  }

  override def hashCode: Int = {
    (41 * hours) + minutes
  }

}

object Clock {

  def apply(hours: Int): Clock = new Clock(hours)
  
}
