import scala.collection.immutable.SortedMap

class School {

  private var classes = SortedMap[Int, Seq[String]]().withDefaultValue(List[String]())

  def db: Map[Int, Seq[String]] = classes

  def add(name: String, grade: Int): Unit = {    
    classes += (grade -> (classes(grade) :+ name))
  }

  def grade(number: Int): Seq[String] = {
    classes.getOrElse(number, Seq.empty)
  }

  def sorted(): Map[Int, Seq[String]] = {
    classes.mapValues(_.sorted)
  } 

}