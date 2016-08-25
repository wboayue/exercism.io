class Acronym(phrase: String) {

  lazy val abbreviate: String = {
    val a = Acronym.SplitPattern
      .split(phrase)
      .filter(!_.isEmpty)
      // .map(_.head)
      // .mkString
      // .toUpperCase
      println(a.toList)
      a.mkString
  }

}

object Acronym {

  val SplitPattern = """(?=[A-Z][A-Z]?)|[ -]""".r

  def apply(phrase: String) = new Acronym(phrase)

}