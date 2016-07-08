case class Acronym(phrase: String) {

  val abbreviate: String = {
    val (acronym, previous) = phrase.foldLeft(("", ' ')) {
      (acc: (String, Char), current: Char) =>
        acc match {
          case (acronym, previous) if isBreakPoint(current, previous) => (acronym + current, current)
          case (acronym, _) => (acronym, current)
        }
    }

    acronym.toUpperCase
  }

  private def isBreakPoint(current: Char, previous: Char): Boolean = {
    Set(' ', '-').contains(previous) || (current.isUpper && previous.isLower)
  }

}
