package unitconverter.converters

import scala.io.StdIn.readLine

object LengthConverter {
  val conversion: Map[String, Double => Double] = Map(
    "1" -> metersToFeet,
    "2" -> feetToMeters,
    "3" -> kilometersToMiles,
    "4" -> milesToKilometers,
    "5" -> inchesToCentimeters,
    "6" -> centimetersToInches
  )

  def actionPrompt(): Unit = {
    val prompts : String =
      """
        |1. Meters to Feet.
        |2. Feet to Meters.
        |3. Kilometers to Miles.
        |4. Miles to Kilometers.
        |5. Inches to Centimeters.
        |6. Centimeters to Inches.
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

  def metersToFeet (dist: Double): Double = dist * 3.28
  def feetToMeters (dist: Double): Double = dist * 0.3;
  def kilometersToMiles(dist: Double): Double = dist * 0.62
  def milesToKilometers(dist: Double): Double = dist * 1.6;
  def inchesToCentimeters(dist: Double): Double = dist * 2.54
  def centimetersToInches(dist: Double): Double = dist * 0.39;
}
