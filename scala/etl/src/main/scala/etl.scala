object ETL {

  def transform(input: Map[Int, Seq[String]]): Map[String, Int] = for {
    (score, words) <- input 
    word <- words
  } yield (word.toLowerCase, score)

}

