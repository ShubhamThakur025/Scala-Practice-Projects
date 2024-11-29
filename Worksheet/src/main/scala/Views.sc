/**
 * Transformers are method, that when applied on collections, return a new collection with some our-defined method applied on it.
 * Transforms can work in either of the two manners: Strictly or Lazily. Strictly, they'll return the whole collection at once with all
 * the operations applied on it. Lazily, they'll return a collection but would only apply the operation (method) once we demand them.
 */

//Mimicking a lazy transformer. Here the lazyMap constructs a new Iterable without stepping through teh given collection iter. The given function f is instead applied to the elements of the result collections as tehy are demanded
def lazyMap[T,U](iter: Iterable[T], f: T => U) = new Iterable[U]:
  def iterator = iter.iterator.map(f)

lazyMap(List(1,2,3), ele => ele* 2)

/**
 * Scala collections are by-default strict (except for lazy-list). A good way to make them lazy is through view.
 *
*/
val ll = LazyList(1,2,3,4)
ll.map(ele => ele*2)
ll(2)
ll

//val v = Vector((1 to 10)*) <- Way to unwrap this range and spread to this vector
val v = Vector((1 to 10)*)
val ans = v.view.map(e => e * 2)
ans(3)
ans.foreach(ele => print(s"$ele "))
//now, suppose, we wish to first add 1 to every element in v then multiply by 2
v.map(_ + 1).map(_*2)
//sometimes, creating intermediate collections between the two maps is a bit-wasteful. Instead, convert the collection to view then apply operations then to collection again.
v.view.map(_+1).map(_*2).to(Vector)

//Views have the following characetristics:
// 1. Transformation method takes O(1) constant time.
// 2. Accessing elements takes the time equal to the underlying data structure.



