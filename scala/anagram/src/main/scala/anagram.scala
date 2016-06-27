class Anagram(base: String) {

  val baseLower = base.toLowerCase
  val baseSorted = baseLower.sorted

  def matches(words: Seq[String]): Seq[String] = {
    words.filter(word => isAnagram(word))
  }

  def isAnagram(word: String) = {
    val wordLower = word.toLowerCase

    if (baseLower == wordLower) {
      false
    } else {
      baseSorted == wordLower.sorted
    }
  }
}
