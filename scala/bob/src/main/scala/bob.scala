class Bob {

  def hey(phrase: String): String = phrase.trim() match {
    case phrase if silence(phrase) => "Fine. Be that way!"
    case phrase if shouting(phrase) => "Whoa, chill out!"
    case phrase if questioning(phrase) => "Sure."
    case _ => "Whatever."
  }

  def silence(phrase: String): Boolean = {
    phrase == ""
  }

  def shouting(phrase: String): Boolean = {
    phrase.exists(_.isLetter) && !phrase.exists(Character.isLowerCase(_))
  }

  def questioning(phrase: String): Boolean = {
    phrase.endsWith("?")
  }
}
