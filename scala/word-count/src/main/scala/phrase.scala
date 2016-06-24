class Phrase(text: String) {

  def wordCount(): Map[String, Int] = {
    countWords(splitIntoWords(text))
  }

  private def countWords(words: List[String]): Map[String, Int] = {
    words.groupBy(w => w).mapValues(_.size)
  }

  private def splitIntoWords(phrase: String): List[String] = {
    stripPunctuation(phrase).
      toLowerCase().
      split("[ _,]").
      filter(w => w.size > 0).
      toList
  }

  private def stripPunctuation(phrase: String): String = {
    phrase.trim.replaceAll("[:!&@$%^.]", "")
  }

}
