import scala.collection.immutable.TreeMap

class School {

  private var classes = TreeMap[Int, Seq[String]]()

  def db: Map[Int, Seq[String]] = classes

  def add(name: String, grade: Int): Unit = {
    val students: Seq[String] = classes.getOrElse(grade, List[String]())
    classes = classes + (grade -> (students :+ name))
  }

  def grade(number: Int): Seq[String] = {
    classes.getOrElse(number, Seq.empty)
  }

  def sorted(): Map[Int, Seq[String]] = {
    classes.mapValues(_.sorted)
  } 

}