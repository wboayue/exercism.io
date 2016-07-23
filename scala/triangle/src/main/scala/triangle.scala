class Triangle(a: Int, b: Int, c: Int) {

  def triangleType(): TriangleType.Value = {
    if (isIllogical) {
      TriangleType.Illogical      
    } else if (isEquilateral) {
      TriangleType.Equilateral
    } else if (isIsosceles) {
      TriangleType.Isosceles
    } else {
      TriangleType.Scalene
    }
  }

  private def isIllogical(): Boolean = {
    List(a, b, c)
      .permutations
      .exists{case List(d, e, f) => d + e < f} 
  }

  private lazy val isEquilateral = a == b && b == c

  private lazy val isIsosceles = a == b || a == c || b == c
}

object Triangle {
  def apply(a: Int, b: Int, c: Int): Triangle = new Triangle(a, b, c)
}

object TriangleType extends Enumeration {
  val Equilateral, Isosceles, Scalene, Illogical = Value
}

