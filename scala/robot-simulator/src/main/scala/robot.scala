case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  def advance() = (bearing, coordinates) match {
    case (Bearing.North, (x, y)) => Robot(bearing, (x, y + 1))
    case (Bearing.South, (x, y)) => Robot(bearing, (x, y - 1))
    case (Bearing.East, (x, y)) => Robot(bearing, (x + 1, y))
    case (Bearing.West, (x, y)) => Robot(bearing, (x - 1, y))
  }

  def turnLeft() = bearing match {
    case Bearing.North => Robot(Bearing.West, coordinates)
    case Bearing.South => Robot(Bearing.East, coordinates)
    case Bearing.East => Robot(Bearing.North, coordinates)
    case Bearing.West => Robot(Bearing.South, coordinates)
  }

  def turnRight() = bearing match {
    case Bearing.North => Robot(Bearing.East, coordinates)
    case Bearing.South => Robot(Bearing.West, coordinates)
    case Bearing.East => Robot(Bearing.South, coordinates)
    case Bearing.West => Robot(Bearing.North, coordinates)
  }

  def simulate(actions: String): Robot = {
    actions.foldLeft(this) {
      case (robot, action) => action match {
        case 'A' => robot.advance
        case 'L' => robot.turnLeft
        case 'R' => robot.turnRight
        case _ => throw new IllegalArgumentException(s"Unsupported robot action '#{action}'")
      }
    }
  }

}

sealed abstract class Bearing

object Bearing {
  case object North extends Bearing
  case object South extends Bearing
  case object East extends Bearing
  case object West extends Bearing
}
