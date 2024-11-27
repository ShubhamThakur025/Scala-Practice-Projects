import scala.collection.immutable.Queue

/**
 * Lists
 * List are finite immutable sequences. Generally, they take linear time for most operations. Moreover, a constant-time to access the first element and rest ones too.
 */
val list: List[Int] = List(1,2,3,4)
list.isDefinedAt(3)
list(2)
val emptyList: List[Int] = List() //Nil //List.empty
val oneElementList = 6 :: Nil //List(6)

// Lazy Lists are the lazy forms of list. Their elements are computed lazily (computed only when requested) and can be infinite
val ll = LazyList(1,2,3,3,4,4) //LazyList(<not computed>)
ll(1) //2
ll //LazyList(1, 2, <not computed>)
val nl = ll #:: 3 #:: LazyList.empty
nl.last

//An Amazing example of Fibonacci series using lazy lists
def fibFrom (a: Int, b : Int): LazyList[Int] = a #:: fibFrom(b, a + b)
val ans = fibFrom(0,1).take(8)
ans.foreach(i => print(s"$i "))


/**
 * ArraySeq are immutable sequences that offer us constant time complexity while accessing any random element from the sequence. This was missing in the lists.
*/
val arr = collection.immutable.ArraySeq(1,2,3,4)
arr(2)

/**
 * Lists are preferred when only head and simplicity is needed. ArraySeq are preferred when random access is required.
 * VECTORS on the other hand, provides efficiency for every operation. Thus, they've a constant time complexity for random access and head too.
 * They are implemented as trees with high branching factor (number of children a node can have). A node can accommodate up to 32 elements of the vector. Therefore, we make a new node only when we cross 32. Such structure and organization makes vector an impressive balance between lists and arraySeq.
*/
val vec = Vector(1,2,3)
vec(2)

/**
 * Other collections:
*/

//1. Immutable queue
val empty = Queue[Int](1,2,3)
val oneEle = empty.enqueue(4)
val (element, emptyAgain) = oneEle.dequeue // returns a pair of removed element and the new queue

//2. Ranges: When we wish to make a range with equal space. Eg1: 1,2,3,4 Eg2: 1,3,5,7,9
val eg1 = 1 to 4
val eg2 = 1 to 9 by 2
val eg3 = 1 to 10 by 5
eg3.foreach(ele => print(s"$ele "))
//If you want the upper bound to be exclusive
val eg4 = 1 until 4
eg1.foreach(e => print(s"$e "))
eg4.foreach(e => print(s"$e "))


//Others -> ListMap, VectorMap, BitSet, RedBlackTrees, Hash Tries
