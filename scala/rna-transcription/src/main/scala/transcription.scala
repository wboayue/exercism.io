object Dna {

  def apply() = this

  val DnaRna = Map[Char, Char](
    'G' -> 'C',
    'C' -> 'G',
    'T' -> 'A',
    'A' -> 'U'
  )

  def toRna(dna: String): String = {
    dna map DnaRna
  }

}