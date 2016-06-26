class Anagram(base: String) {

  val baseLower = base.toLowerCase

  def matches(words: Seq[String]): Seq[String] = {
    words.filter(word => isAnagram(word))
  }

  def isAnagram(word: String) = {
    val wordLower = word.toLowerCase

    if (baseLower == wordLower) {
      false
    } else {
      baseLower.sorted == wordLower.sorted
    }
  }
}
