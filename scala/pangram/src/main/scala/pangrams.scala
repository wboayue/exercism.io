object Pangrams {
  
  val alphabets = "abcdefghijklmnopqrstuvyxyz"

  def isPangram(sentence: String): Boolean = {
    val lower = sentence.toLowerCase
    
    alphabets.forall(lower.contains(_))
  }

}