import scala.annotation.tailrec

// i.
def returnFirstElement(l: List[Int]): Option[Int] = {
  l match {
    case Nil => None
    case head::_ => Some(head)
  }
}

returnFirstElement(List(54, 59, 40, 50))

// ii.
def largerValue(i: Int, iOpt: Option[Int]): Option[Int] = {
  iOpt match {
    case None => None
    case Some(value) => Some(i max value)
  }
}

def largestElement(l: List[Int]): Option[Int] = {
  l match {
    case Nil => None
    case head::Nil => Some(head)
    case head::tail => largerValue(head, largestElement(tail))
  }
}

largestElement(List(54, 59, 40, 50))

// iii.
def concatenateStringOption(lhs: String, rhsOpt: Option[String]): Option[String] = {
  rhsOpt match {
    case None => None
    case Some(rhs) => Some(lhs + rhs)
  }
}

def replicateNTimes(s: Option[String], i: Option[Int]): Option[String] = {
  (s, i) match {
    case (_, None) => s
    case (None, _) => None
    case (_, Some(0)) => Some("")
    case (_, Some(num)) if num < 0 => None
    case (Some(str), Some(num)) => {
      val tail: Option[String] = replicateNTimes(Some(str), Some(num - 1))
      concatenateStringOption(str, tail)
    }
  }
}

val someString = Some("Test")
val someInteger = Some(10)

replicateNTimes(someString, someInteger)

