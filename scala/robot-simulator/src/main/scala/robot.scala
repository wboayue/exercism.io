case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  def advance() = (bearing, coordinates) match {
    case (Bearing.North, (x, y)) => copy(coordinates=(x, y + 1))
    case (Bearing.South, (x, y)) => copy(coordinates=(x, y - 1))
    case (Bearing.East, (x, y)) => copy(coordinates=(x + 1, y))
    case (Bearing.West, (x, y)) => copy(coordinates=(x - 1, y))
  }

  def turnLeft() = bearing match {
    case Bearing.North => copy(bearing=Bearing.West)
    case Bearing.South => copy(bearing=Bearing.East)
    case Bearing.East => copy(bearing=Bearing.North)
    case Bearing.West => copy(bearing=Bearing.South)
  }

  def turnRight() = bearing match {
    case Bearing.North => copy(bearing=Bearing.East)
    case Bearing.South => copy(bearing=Bearing.West)
    case Bearing.East => copy(bearing=Bearing.South)
    case Bearing.West => copy(bearing=Bearing.North)
  }

  def simulate(actions: String): Robot = {
    actions.foldLeft(this) {
      case (robot, 'A') => robot.advance
      case (robot, 'L') => robot.turnLeft
      case (robot, 'R') => robot.turnRight
      case _ => throw new IllegalArgumentException(s"Unsupported robot action '#{action}'")
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
