class Sublist {
  import Sublist.SublistList

  def sublist[T](a: List[T], b: List[T]) = {
    if (a == b) {
      Sublist.Equal
    } else if (a isSublistOf b) {
      Sublist.Sublist
    } else if (b isSublistOf a) {
      Sublist.Superlist
    } else {
      Sublist.Unequal
    }
  }
}

trait SublistType

object Sublist {
  case object Equal extends SublistType
  case object Unequal extends SublistType
  case object Sublist extends SublistType
  case object Superlist extends SublistType

  implicit class SublistList[T](a: List[T]) {

    def isSublistOf(b: List[T]): Boolean = {
      a.isEmpty ||
        b.sliding(a.size, 1).exists(b => a == b)
    }

  }
}
