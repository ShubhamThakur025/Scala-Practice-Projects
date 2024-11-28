/**
 * Arrays are special kind of collections in Scala. Firstly, they directly correspond to their counterparts in Java. For instance, Array[Int] -> int[] or Array[Double] -> double[]. However, they are different and better than Java's Arrays in some sense:
 * 1. Scala Arrays are generic. It means that Array[T] invites any data type or an abstract type too unlike Java's different styles for each datatype array -> int[], double[] etc.
 * 2. Scala Arrays are compatible with sequences. Therefore, we can pass an array where a sequence was required. Moreover, provides methods same as sequences. This happens because there's an implicit conversion of Arrays to ArraySeq
 */

val arr1: Array[Int] = Array(1,2,3)
val arr2: Array[String] = Array("ram", "sita")
arr1.foreach(ele => print(s"$ele "))
arr2.foreach(ele => print(s"$ele "))

/**
 * How does this implicit conversion takes place?
 * There are two conversions that can actually take place -> conversion to ArraySeq or conversion to ArrayOps.
 * ArrayOps is another collection that supports sequential operations. However, we're going to explicit initialize it in no-world.
 *
 * ArrayOps is defined in Predef object that inherits the scala.LowPriorityImplicits class where ArraySq is present. When both implicit conversions are application, one in the Predef is prioritized over the other one.
*/

//to Create a generic array method mimic the following function
import scala.reflect.ClassTag
def evenElems[T: ClassTag](xs: Vector[T]): Array[T] =
  val arr = new Array[T]((xs.length + 1) / 2)
  for i <- 0 until xs.length by 2 do
    arr(i / 2) = xs(i)
  arr
val v = Vector(true, false, true, false)
evenElems(v)
evenElems(Vector("shubham", "thakur"))