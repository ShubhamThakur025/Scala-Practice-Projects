import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

/**
 * When we need to perform conversion of scala collections to java or vice versa, we can make use of Collection Converters object.
 Such a use case may occur while working with libraries/dependencies made for java but can interoperated with Scala for instance -> Apache POI  */

val arr = ArrayBuffer(1,2,4).asJava
val j: java.util.List[Int] = ArrayBuffer(1,2,4).asJava
j.asScala
//Some conversion:
//Iterator               <=>     java.util.Iterator
//Iterator               <=>     java.util.Enumeration
//Iterable               <=>     java.lang.Iterable
//Iterable               <=>     java.util.Collection
//mutable.Buffer         <=>     java.util.List
//mutable.Set            <=>     java.util.Set
//mutable.Map            <=>     java.util.Map
//mutable.ConcurrentMap  <=>     java.util.concurrent.ConcurrentMap
//Seq           =>    java.util.List
//mutable.Seq   =>    java.util.List
//Set           =>    java.util.Set
//Map           =>    java.util.Map