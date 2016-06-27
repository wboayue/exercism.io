class Phrase(text: String) {

  def wordCount(): Map[String, Int] = {
    countWords(splitIntoWords(text))
  }

  private def countWords(words: Seq[String]): Map[String, Int] = {
    words.groupBy(identity).mapValues(_.size)
  }

  private def splitIntoWords(phrase: String): Seq[String] = {
    phrase
      .toLowerCase()
      .split("[^\\w']+")
  }

}
