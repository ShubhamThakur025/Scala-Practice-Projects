package unitconverter.converters

import scala.io.StdIn.readLine

object TemperatureConverter {
  val conversion: Map[String, Double => Double] = Map(
    "1" -> celsiusToFahrenheit,
    "2" -> fahrenheitToCelsius,
    "3" -> celsiusToKelvin,
    "4" -> kelvinToCelsius
  )
  def actionPrompt(): Unit = {
    val prompts: String =
      """
        |1. Celsius to Fahrenheit.
        |2. Fahrenheit to Celsius.
        |3. Celsius to Kelvin.
        |4. Kelvin to Celsius.
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
  def celsiusToFahrenheit(temp: Double) = (temp * 9/5) + 32
  def fahrenheitToCelsius(temp: Double) = (temp - 32) * 5/9
  def celsiusToKelvin(temp: Double) = temp + 273.15
  def kelvinToCelsius(temp: Double) = temp - 273.15
}
