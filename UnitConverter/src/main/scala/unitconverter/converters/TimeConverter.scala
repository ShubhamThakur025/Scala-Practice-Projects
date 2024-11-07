package unitconverter.converters

import scala.io.StdIn.readLine

object TimeConverter {
  val conversion: Map[String, Double => Double] = Map(
    "1" -> hoursToMinutes,
    "2" -> minutesToHours,
    "3" -> daysToHours,
    "4" -> weeksToDays
  )

  def actionPrompt(): Unit = {
    val prompts: String =
      """
        |1. Hours to Minutes.
        |2. Minutes to Hours.
        |3. Days to Hours.
        |4. Weeks to Days.
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
  
  def hoursToMinutes (time: Double) = time * 60
  def minutesToHours (time: Double) = time * 60
  def daysToHours (time: Double) = time * 24
  def weeksToDays (time: Double) = time * 7
}
