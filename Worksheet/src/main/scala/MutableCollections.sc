import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * Array Buffers are mutable sequences suitable for random-access time complexity. We can convert them easily to Array
 */
val ab = ArrayBuffer[Int](1, 2, 3)
ab += 4
val abArray = ab.toArray

/**
 * List Buffers are mutable sequences that are internally implemented as a LinkedList. If ye to plan to convert them to List prefer to use List Buffer.
*/
val lb = ListBuffer[Int](1, 2, 3)
lb += 4
val lbArray = lb.toList

/**
 * String Builders are useful to create Strings
*/
val sb = StringBuilder()
sb += 'a'
sb += 'b'
sb.toString()

/**
 * In case, we wish to prepend and append elements to both sides of an Array, prefer ArrayDeque over ArrayBuffer
*/
val ad = mutable.ArrayDeque(1,3,4)
ad += 4
ad.prepend(4)
ad.foreach(ele => print(s"$ele "))

/**
 * Queues and Stacks
*/
val stk = mutable.Stack(1,2,3)
stk.push(1)
stk.pop()
stk

val quu = mutable.Queue(1,2,3)
quu.enqueue(3,4,55)
quu.dequeue()
quu

//Others: Mutable BitSets, HashTables, ArraySeq, Concurrent Map