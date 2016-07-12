import scala.annotation.tailrec

class Accumulate() {

  def accumulate[X, Y](mapper: (X) => Y, items: List[X]): List[Y] = {
    accumulate(mapper, items, Nil)
  }

  @tailrec
  private def accumulate[X, Y](mapper: (X) => Y, items: List[X], accumulator: List[Y]): List[Y] = {
    items match {
      case Nil => accumulator.reverse
      case head :: tail => accumulate(mapper, tail, mapper(head) :: accumulator)
    }
  }

}