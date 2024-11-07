package unitconverter.converters

import scala.io.StdIn.readLine

object AreaConverter {
  val conversion: Map[String, Double=>Double] = Map(
    "1" -> squareMetersToSquareFeet,
    "2" -> squareMetersToSquareFeet,
    "3" -> acresToSquareMeters,
    "4" -> squareMetersToAcres
  )
  def actionPrompt(): Unit = {
    val prompts: String =
      """
        |1. SquareMeters to SquareFeet.
        |2. SquareFeet to SquareMeters.
        |3. Acres to SquareMeters.
        |4. SquareMeters to Acres.
        |Others: Exit converter.
        |""".stripMargin
    println(s"Press the appropriate key for the action: \n ${prompts}")
  }
  def driver(): Unit = {
    actionPrompt()
    val input = readLine()
    conversion.get(input) match {
      case Some(conversion) =>
        val input2 = readLine().toDouble
        println(conversion(input2))
      case None => println("Invalid Input.")
    }
  }
  def squareMetersToSquareFeet(area: Double) = area * 10.76;
  def squareFeetToSquareMeters(area: Double) = area * 0.09
  def acresToSquareMeters(area: Double) = area * 4046.86;
  def squareMetersToAcres(area: Double) = area * 0.0002
}
