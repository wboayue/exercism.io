class Phrase(text: String) {

  def wordCount(): Map[String, Int] = {
    countWords(splitIntoWords(text))
  }

  private def countWords(words: Seq[String]): Map[String, Int] = {
    words.foldLeft(Map[String, Int]()) {
      (counts, word) => counts + (word -> (counts.getOrElse(word, 0) + 1))
    }
  }

  private def splitIntoWords(phrase: String): Seq[String] = {
    phrase
      .toLowerCase()
      .split("[^\\w']+")
  }

}
