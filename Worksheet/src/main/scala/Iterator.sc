/**
 * Iterator is not a collection rather a way to access elements of the collection one by one. It has two basic operations:
 * 1. .next() -> To move on to the next element of the collection. if no next exists, it will give
 * 2. .hasNext -> To check if there is a next element or not (obviously)
 */

val v = Vector(1,2,3,4,5)
val it = v.iterator
while it.hasNext do
  print(s"${it.next()} ")
it.foreach(ele => println(ele))

//Important to note that when we call foreach on itertor, it leaves the iterator on the end so when we'll do next(), it would an exception
it.next() // this will give error

//Iterators generally work lazily
val it2 = v.iterator
val it2map = it2.map(_*2)
