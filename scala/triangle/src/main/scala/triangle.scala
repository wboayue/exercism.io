class Triangle(a: Int, b: Int, c: Int) {

  val sides = List(a, b, c)

  def triangleType(): TriangleType.Value = {
    if (isIllogical) { TriangleType.Illogical }
    else sides.toSet.size match {
      case 1 => TriangleType.Equilateral
      case 2 => TriangleType.Isosceles
      case 3 => TriangleType.Scalene
    }    
  }

  private def isIllogical(): Boolean = {
    sides
      .permutations
      .exists{case List(d, e, f) => d + e < f}
  }

}

object Triangle {
  def apply(a: Int, b: Int, c: Int): Triangle = new Triangle(a, b, c)
}

object TriangleType extends Enumeration {
  val Equilateral, Isosceles, Scalene, Illogical = Value
}

