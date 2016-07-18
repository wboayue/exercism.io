class Allergies() {

  def allergies(score: BigInt): List[Allergen] = {
    def checkAllergen(allergen: Allergen): List[Allergen] = {
      if (score testBit allergen.bit) {
        List(allergen)
      } else {
        List.empty[Allergen]
      }
    }

    Allergen.Allergens.flatMap(checkAllergen(_))
  }

  def isAllergicTo(allergen: Allergen, score: BigInt): Boolean = {
    score testBit allergen.bit
  }

}

sealed class Allergen(val bit: Int)

object Allergen {
  val Eggs = new Allergen(0)
  val Peanuts = new Allergen(1)
  val Shellfish = new Allergen(2)
  val Strawberries = new Allergen(3)
  val Tomatoes = new Allergen(4)
  val Chocolate = new Allergen(5)
  val Pollen = new Allergen(6)
  val Cats = new Allergen(7)

  val Allergens = List(Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats)
}

object Allergies {
  def apply() = new Allergies()
}