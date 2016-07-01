import scala.collection.immutable.SortedMap

class School {

  private var students = SortedMap[Int, Seq[String]]().withDefaultValue(Vector[String]())

  def db: Map[Int, Seq[String]] = students

  def add(name: String, grade: Int): Unit = {    
    students += (grade -> (students(grade) :+ name))
  }

  def grade(grade: Int): Seq[String] = {
    students(grade)
  }

  def sorted(): Map[Int, Seq[String]] = {
    students.mapValues(_.sorted)
  } 

}