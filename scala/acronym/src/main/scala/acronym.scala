class Acronym(phrase: String) {

  val abbreviate: String = {
    val (acronym, previous) = phrase.foldLeft(("", ' ')) {
      (accumulator: (String, Char), current: Char) =>
        accumulator match {
          case (acronym, previous) if Acronym.isBreakPoint(current, previous)
            => (acronym + Character.toUpperCase(current), current)
          case (acronym, _)
            => (acronym, current)
        }
    }

    acronym
  }

}

object Acronym {

  val Separators = Set(' ', '-')

  def apply(phrase: String) = new Acronym(phrase)

  def isBreakPoint(current: Char, previous: Char): Boolean = {
    Separators.contains(previous) || (current.isUpper && previous.isLower)
  }

}