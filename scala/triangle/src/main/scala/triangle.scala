class Triangle(a: Int, b: Int, c: Int) {

  def triangleType(): TriangleType.Value = {
    if (!isIllogical) {
      TriangleType.Illogical      
    } else if (a == b && b == c) {
      TriangleType.Equilateral
    } else if (a == b || a == c || b == c) {
      TriangleType.Isosceles
    } else {
      TriangleType.Scalene
    }
  }

  def isIllogical(): Boolean = {
    val x = a + b
    val y = b + c
    val z = c + a

    x > c && y > a && z > b
  }

}

object Triangle {
  def apply(a: Int, b: Int, c: Int): Triangle = new Triangle(a, b, c)
}

object TriangleType extends Enumeration {
  val Equilateral, Isosceles, Scalene, Illogical = Value
}

