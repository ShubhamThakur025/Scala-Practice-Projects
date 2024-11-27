/**
 * Maps are collections implementing the iterable. They can contain key-value pairs. They support the following operations:
 * 1. Lookup ops
 * 2. Sub-collections formation
 * 3. Transformations
 * 4. Additions or deletions
 */

val mapp = Map("one"-> 1, "two" -> 2, "one"->4, "three" -> 3) // Alternatively, Map(("one" -> 1), ("two" -> 2))
// we can repeat keys but this would overwrite the previous value

//1. Lookup operations
mapp("two")
mapp("ten") //error
mapp.get("two")
mapp.get("ten") //None -> This is one is better option
mapp.getOrElse("ten", -1)
mapp.contains("ten")
mapp.isDefinedAt("ten") // both are same

///2. Sub-collections
mapp.keys //return iterable
mapp.values.toList
mapp.keySet //return set
mapp.keysIterator
mapp.toList //nested list


//3. Transformations
mapp.view.filterKeys(p => p.length > 3) //.filterKeys is deprecated

//4. Ops
//We can do the +=, -= in mutable maps. For immutable ones, return new maps like mapp + (k -> v)
//mapp.clone cloning in mutable cases
val mutMaps = collection.mutable.Map("one" -> 2)
mutMaps ++ collection.mutable.Map("two" -> 3)
mutMaps.clone()