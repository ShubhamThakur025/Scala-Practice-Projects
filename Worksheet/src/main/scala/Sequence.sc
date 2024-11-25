/**
 * Seq trait represents sequences. There certain operations application to sequences:
 * - Indexing and length
 * - Index Search
 * - Addition
 * - Sorting
 * - Reversal
 * - Multi-set: To perform set-like operations on the sequence.
 * Sequences further have two sub-collections - IndexedSeq and LinkedSeq. IndexedSeq has efficient length, apply and index methods. LinkedSeq has efficient head and tail method
 */
val seq1: Seq[Int] = Seq(1, 2, 3)

//Indexing
seq1(1)
seq1.apply(1) //same as above
seq1.indices
seq1.length

//Index Search
seq1.indexOf(10) //-1
seq1.lastIndexOf(10) //-1
seq1.lastIndexOf(1) //0
seq1.indexOf(1) //0

//Addition
seq1 :+ 1 //appending creates new sequence
seq1.appended(1)
1 +: seq1 // prepending
seq1.prepended(1)

//sorting
seq1.sorted
seq1.sortWith((x,y) => x > y) //sort as per given predicate

//comparison
seq1.contains(2) //more used and easy
seq1.startsWith(Seq(1,2))
seq1.search(2) // more efficient than contains

//Multi-set ops
seq1.intersect(Seq(1, 2))
seq1.diff(Seq(2,3,4))
Seq(1,1,1,1).distinct

/**
 * Buffers are sub-category of mutable sequences. They allow not only updates of existing elements but also element additions, insertions and removals.
*/
