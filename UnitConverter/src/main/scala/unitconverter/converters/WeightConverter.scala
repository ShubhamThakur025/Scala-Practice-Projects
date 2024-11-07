package unitconverter.converters

import scala.io.StdIn.readLine

object WeightConverter {
  val conversion: Map[String, Double => Double] = Map(
    "1" -> kilogramsToPounds,
    "2" -> poundsToKilograms,
    "3" -> gramsToOunces,
    "4" -> ouncesToGrams
  )

  def actionPrompt(): Unit = {
    val prompts: String =
      """
        |1. Kilograms to Pounds.
        |2. Pounds to Kilograms.
        |3. Grams to Ounces.
        |4. Ounces to Grams.
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
  def kilogramsToPounds (weight: Double) = weight * 2.20
  def poundsToKilograms (weight: Double) = weight * 0.45
  def gramsToOunces (weight: Double) = weight * 0.035;
  def ouncesToGrams (weight: Double) = weight * 28.3;
}
