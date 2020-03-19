def reduce(l: List[Int], f: (Int, Int) => Int): Option[Int] =
  l match {
    case Nil => None
    case head :: Nil => Some(head)
    case head :: tail => Some(f(head, reduce(tail, f).get))
  }

val v = reduce(List(1, 2, 3), _-_)

v match {
  case Some(value) => println(value)
  case None => ":("
}

// Normale reduce
// ((1 - 2) - 3) - (-1) -3 = -4

// Deze reduce
// (1 - (2 - 3)) -1 - (-1) = 2