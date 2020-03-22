// 3
val testList = List(1,2,3,4,5,6,7,8)

// i.

val multiplyByTwo: (Int) => Int = (x: Int) => x * 2

def map(l: List[Int], f: (Int) => Int): List[Int] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    val newHead = f(head)
    newHead :: map(tail, f)
  }
}

map(testList, multiplyByTwo)

// ii.

val printElements: (Int) => Unit = (x: Int) => println(x)

def foreach(l: List[Int], f: (Int) => Unit): Unit = {
  if (l == Nil) f(0)
  else {
    val head::tail = l
    f(head)
    foreach(tail, f)
  }
}

foreach(testList, printElements)

// iii.
def reduce(l: List[Int], f: (Int, Int) => Int): Int = {
  if (l == Nil) 1
  else {
    val head::tail = l
    f(head, reduce(tail, f))
  }
}

val multiplyElements: (Int, Int) => Int = (x: Int, y: Int) => x * y

reduce(testList, multiplyElements)

// iv.
def count(l: List[Int], f: (Int) => Boolean): Int = {
  if (l.nonEmpty) {
    val _::tail = l
    1 + count(tail, f)
  }
  else 0
}

val checkIfBiggerThanZero: (Int) => Boolean = (x: Int) => if (x > 0) true else false

val listRangeZeroToHundredRealQuick = List.range(0, 100)
count(List(), checkIfBiggerThanZero)