package unitconverter

import scala.io.StdIn.readLine
import converters.*

import scala.util.control.Breaks.{break, breakable}

object UnitConverter {

  private def start() :Unit = {
    println("============================================================")
    println("Welcome to Unit Converter")
    println("============================================================")
  }

  private def displayMenu(): Unit = {
    val menu =
      """
        |1. Length Converter
        |2. Area Converter
        |3. Temperature Converter
        |4. Weight Converter
        |5. Time Converter
        |6. Show Menu
        |Others: Exit
        |""".stripMargin
    println("Press the key to perform certain action:" + menu)
  }

  def main(args: Array[String]): Unit = {
    start()
    breakable {
      while(true){
        displayMenu()
        readLine() match
          case "1" => LengthConverter.driver()
          case "2" => AreaConverter.driver()
          case "3" => TemperatureConverter.driver()
          case "4" => WeightConverter.driver()
          case "5" => TimeConverter.driver()
          case "6" => displayMenu()
          case _ =>
            println("Exiting...")
            break
      }
    }
  }
}
