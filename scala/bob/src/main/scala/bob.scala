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

  def has_letter(phrase: String): Boolean = {
    ("\\p{L}+".r findFirstIn phrase) != None
  }

  def shouting(phrase: String): Boolean = {
    has_letter(phrase) && phrase.toUpperCase == phrase
  }

  def questioning(phrase: String): Boolean = {
    phrase.endsWith("?")
  }
}
