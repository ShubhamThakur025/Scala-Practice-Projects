/**
 * Scala collections package can be divided further into three sub-packages - root, immutable and mutable. Immutable and mutable guarantees immutability and mutability of the data structures respectively.
 * By default, Scala always picks immutable collections. Root collections data structures can be mutable and immutable.
 */

//View performance stats of every collection here: https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html

/**
 * Iterable trait resides at very top of the collection.
 * It implements some concrete methods that are later inherited by its implementations.
 * The list includes: map, head, to*(Conversions, eg. toList), isEmpty, size, find, exists, forall, folds, collect
 * Some advances methods: grouped (returns the collection in max_size chunks). sliding (provides a sliding window of max_size)
 *
*/

val iter1 = Iterable(1, 2, 3, 4)
iter1.iterator //Returns an iterator that iterates on the whole collection

// Combinators: Applies operation on successive elements of the collection. Fold and Reduce are two kinds. Fold needs an init value but works with empty collections also. Reduce, on the other hand, doesn't require any init value and throws an error when applied on empty collections.
iter1.sum
iter1.fold(0)((x, y) => x + y)
iter1.product
iter1.fold(1)((x, y) => x * y)
iter1.reduce(_+_)

//Compare size
iter1.size
iter1.isEmpty
iter1.nonEmpty
iter1.sizeCompare(100) //compare size with n. returns -1 if less else 1.

//element retrieval
iter1.head
iter1.headOption
iter1.last
iter1.lastOption
iter1.find(i => i % 2 == 0) //returns first element satisfying the predicate wrapped in Some.

//sub collections
iter1.slice(0, 2)
iter1.take(1) //take first 1 element(s)
iter1.drop(1) //take all except first 1 element(s)
iter1.takeWhile(p => p % 1 == 0) //take elements until first one dissatisfying the predicate comes up.
iter1.dropWhile(p => p % 1 == 0) //take all elements including and after first one dissatisfying element came.
iter1.filter(p => p % 2 == 0)
iter1.filterNot(p => p % 2 == 0)

//conditional
iter1.exists(p => p % 1 == 0) //Some
iter1.forall(p => p % 1 == 0) //Every
iter1.count(p => p % 1 == 0) //Count satisfying the condition

//strings
iter1.mkString("Start", ", ", "") //Start1, 2, 3, 4 -> Converts the collection to string starting with start, separated by sep and ending with End
val iter2 = iter1.filter(p => p % 2 == 0)
//Both produces the same result -> concatenating the two collections.
iter1 ++ iter2
iter1.concat(iter2)

//.collect
val evenNumbers = iter1.collect {
  case num if num % 2 == 0 => num*6
}
//.collect is a combination of filter and map -> create a new collection and apply operations on elements that satisfy a given condition.
