object Pangrams {
  
  val alphabets = ('a' to 'z')

  def isPangram(sentence: String): Boolean = {
    val lower = sentence.toLowerCase

    alphabets.forall(lower.contains(_))
  }

}