class Allergies() {
  import Allergen.Allergen

  def allergies(score: BigInt): List[Allergen] = {
    Allergen.values.filter(isAllergicTo(_, score)).toList
  }

  def isAllergicTo(allergen: Allergen.Allergen, score: BigInt): Boolean = {
    score testBit allergen.id
  }

}

object Allergies {
  def apply() = new Allergies()
}

object Allergen extends Enumeration {
  type Allergen = Value

  val Eggs = Value(0)
  val Peanuts = Value(1)
  val Shellfish = Value(2)
  val Strawberries = Value(3)
  val Tomatoes = Value(4)
  val Chocolate = Value(5)
  val Pollen = Value(6)
  val Cats = Value(7)
}
