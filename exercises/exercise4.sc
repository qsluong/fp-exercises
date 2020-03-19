// 2

// ii.
//def largestIntValue(i: Int, o: Option[Int]): Int =
//  o match {
//    case None => i
//    case Some(value) if (value > i) => value
//  }
//
//def largestElementInList(l:List[Int]): Option[Int] =
//  l match {
//    case Nil => None
//    case head :: tail => Some(largestIntValue(head, largestElementInList(tail)))
//  }
//
//largestElementInList(List(3, 2, 1))

// 3

// i
def squareRootOfX(e: Either[Double, String]): Either[Double, String] =
  e match {
    case Left(x) if x < 0.0 => Right("Input is negative")
    case Left(x) => Left(math.sqrt(x))
    case Right(x) => Right(x)
  }

def divideTenByX(e: Either[Double, String]): Either[Double, String] =
  e match {
    case Left(0) => Right("Input is zero")
    case Left(x) => Left(10 / x)
    case Right(x) => Right(x)
  }

def divideOneByXMinusOne(e: Either[Double, String]): Either[Double, String] =
  e match {
    case Left(1) => Right("Input is one")
    case Left(x) => Left(1 / x -1)
    case Right(x) => Right(x)
  }

squareRootOfX(Left(-1))
squareRootOfX(Left(1))

divideTenByX(Left(0))
divideTenByX(Left(1))

divideOneByXMinusOne(Left(1))
divideOneByXMinusOne(Left(2))

val chainedFunctions = squareRootOfX _ andThen divideTenByX andThen divideOneByXMinusOne

chainedFunctions(Left(1))

