class Garden(students: List[String], plots: String) {

  val plants: Map[String, List[Plant]] = {
    Garden.build(students.sorted.toArray, plots.split("\n"))
  }

  def getPlants(name: String): List[Plant] = {
    plants(name)
  }

}

object Garden {

  def apply(students: List[String], plots: String): Garden = new Garden(students, plots)

  def defaultGarden(plots: String): Garden = Garden(DefaultStudents, plots)

  def build(students: Array[String], plots: Seq[String]): Map[String, List[Plant]] = {
    var garden = Map.empty[String, List[Plant]].withDefaultValue(List.empty[Plant])

    for (plot <- plots; (plant, i) <- plot.zipWithIndex) {
      val student = students(i/2)
      garden += (student -> (garden(student) :+ PlantNames(plant)))
    }

    garden
  }

  val DefaultStudents = List("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny",
    "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")

  val PlantNames: Map[Char, Plant] = Map(('C' -> Plant.Clover), ('G' -> Plant.Grass),
    ('R' -> Plant.Radishes), ('V' -> Plant.Violets))
}

sealed trait Plant
object Plant {
  case object Clover extends Plant
  case object Grass extends Plant
  case object Radishes extends Plant
  case object Violets extends Plant
}
