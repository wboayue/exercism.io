class Phrase(text: String) {

  def wordCount(): Map[String, Int] = {
    countWords(splitIntoWords(text))
  }

  private def countWords(words: List[String]): Map[String, Int] = {
    words.groupBy(identity).mapValues(_.size)
  }

  private def splitIntoWords(phrase: String): List[String] = {
    phrase.
      toLowerCase().
      split("[^\\w']+").
      toList
  }

}
