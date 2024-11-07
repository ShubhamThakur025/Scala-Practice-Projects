package calculator

import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}
import scala.util.{Try, Success, Failure}

object CalculatorCLI {

  private def start(): Unit = {
    println("Welcome to the calculator!")
    println("=========================================")
  }

  private def displayMenu(): Unit = {
    val menu: String =
      """
        |1. Add
        |2. Subtract
        |3. Multiply
        |4. Divide
        |5. Power
        |6. Show Menu
        |Others: Exit
        |""".stripMargin
    println("Press the key to perform certain action:" + menu)
  }

  private def add(num1: Double, num2: Double) = num1 + num2
  private def subtract(num1: Double, num2: Double) = num1 - num2
  private def multiply(num1: Double, num2: Double) = num1 * num2
  private def divide(num1: Double, num2: Double) : Try[Double] = {
    if(num2 == 0) Failure(new ArithmeticException("You cannot divide a number by 0!"))
    else Success(num1 / num2)
  }

  private def power(num1: Double, num2: Double) = {
    Math.pow(num1, num2)
  }

  private def inputNumbers: Array[Double] = {
    println("Enter the first number (can be double)")
    val num1 = readLine().toDouble
    println("Enter the second number (can be double)")
    val num2 = readLine().toDouble
    Array(num1, num2)
  }

  private def printResult(result: Double): Unit = println(s"The result is ${result}")

  def main(args: Array[String]): Unit = {
    start()
      breakable{
        while (true) {
          displayMenu()
          val input = readLine()
          input match {
            case "1" =>
              val Array(num1, num2) = inputNumbers
              printResult(add(num1, num2))
            case "2" =>
              val Array(num1, num2) = inputNumbers
              printResult(subtract(num1, num2))
            case "3" =>
              val Array(num1, num2) = inputNumbers
              printResult(multiply(num1, num2))
            case "4" =>
              val Array(num1, num2) = inputNumbers
                divide(num1,num2) match
                case Success(result) => printResult(result)
                case Failure(ex) => println(s"An Error Occurred: \n${ex.getMessage}")
            case "5" =>
              val Array(num1, num2) = inputNumbers
              printResult(power(num1, num2))
            case "6" =>
              displayMenu()
            case _ =>
              println("Exiting....")
              break
          }
        }
      }
    }
}
