import scala.annotation.tailrec

class Accumulate() {

  def accumulate[X, Y](mapper: (X) => Y, items: List[X]): List[Y] = {
    accumulate(mapper, items, List[Y]())
  }

  @tailrec
  private def accumulate[X, Y](mapper: (X) => Y, items: List[X], accumulator: List[Y]): List[Y] = {
    if (items.isEmpty) {
      accumulator.reverse
    } else {
      accumulate(mapper, items.tail, mapper(items.head) :: accumulator)
    }
  }

}