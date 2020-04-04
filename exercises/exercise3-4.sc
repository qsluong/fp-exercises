// i.
def swap(l: List[(String, Int)]): List[(Int, String)] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    val (s, i) = head
    (i, s)::swap(tail)
  }
}

val listOfTuples: List[(String, Int)] = List(("Test", 1), ("Mongo", 2))

swap(listOfTuples)

// ii.
def zip(l: List[Int], k: List[Int]): List[(Int, Int)] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    val head2::tail2 = k
    (head, head2)::zip(tail, tail2)
  }
}

val l1 = List(52, 64, 78, 19, 10)
val l2 = List(10, 36, 44, 21, 31)

zip(l1, l2)