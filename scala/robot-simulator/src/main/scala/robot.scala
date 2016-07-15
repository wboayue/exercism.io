case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  def advance() = copy(coordinates=bearing.advance(coordinates))
  def turnLeft() = copy(bearing=bearing.turnLeft)
  def turnRight() = copy(bearing=bearing.turnRight)

  def simulate(actions: String): Robot = {
    actions.foldLeft(this) {
      case (robot, 'A') => robot.advance
      case (robot, 'L') => robot.turnLeft
      case (robot, 'R') => robot.turnRight
      case _ => throw new IllegalArgumentException(s"Unsupported robot action '#{action}'")
    }
  }

}

class Bearing(left: String, right: String, x: Int, y: Int) {

  def turnLeft = Bearing.Bearings(left)
  def turnRight = Bearing.Bearings(right)

  def advance(coordinates: (Int, Int)) = {
    coordinates match {
      case (current_x, current_y) => (current_x + x, current_y + y)
    }
  }
}

object Bearing {
  case object North extends Bearing(left="west", right="east", x=0, y=1)
  case object South extends Bearing(left="east", right="west", x=0, y=(-1))
  case object East extends Bearing(left="north", right="south", x=1, y=0)
  case object West extends Bearing(left="south", right="north", x=(-1), y=0)

  val Bearings: Map[String, Bearing] = Map[String, Bearing](
    ("north" -> North),
    ("south" -> South),
    ("east" -> East),
    ("west" -> West)
  )
}
