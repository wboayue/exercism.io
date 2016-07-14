class Accumulate() {

  def accumulate[X, Y](mapper: (X) => Y, items: List[X]): List[Y] = {
    items.foldRight(List[Y]()) {
      case (item, results) => mapper(item) :: results
    }
  }

}