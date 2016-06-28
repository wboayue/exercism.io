class Anagram(base: String) {

  val baseLower = base.toLowerCase
  val baseSorted = baseLower.sorted

  def matches(words: Seq[String]): Seq[String] = {
    words.filter(isAnagram(_))
  }

  def isAnagram(word: String) = {
    val wordLower = word.toLowerCase

    (baseLower != wordLower) && (baseSorted == wordLower.sorted)
  }
}
