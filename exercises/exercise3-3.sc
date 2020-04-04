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
  if (l == Nil) 0
  else {
    val head::tail = l
    val isHead = f(head)
    if (isHead) 1 + count(tail,f)
    else 0 + count(tail, f)
  }
}

val checkIfNumberIsBiggerThanZero: (Int) => Boolean = (x: Int) => if (x > 0) true else false

count(List(0,1,2,3,4,5), checkIfNumberIsBiggerThanZero)

// v.
// Takes predicate function and returns boolean if all elements matches predicate
def forall(l: List[Int], f: (Int) => Boolean): Boolean = {
  if (l == Nil) false
  else {
    val head::tail = l
    val isHead = f(head)
    println(isHead)
    if (l.length == 1) isHead
    else if (isHead) forall(tail, f)
    else false
  }
}

forall(List(1, 1, 1, 3, 4 ,5), checkIfNumberIsBiggerThanZero)

// vi.
// Takes predicate functions and returns the first element that matches the predicate
def exists(l: List[Int], f: (Int) => Boolean): Boolean = {
  if (l == Nil) false
  else {
    val head::tail = l
    val isHead = f(head)
    println(isHead)
    if (isHead) isHead
    else exists(tail, f)
  }
}

exists(List(0, 0, 2, 0, 0, 6), checkIfNumberIsBiggerThanZero)

// vii.
def filter(l: List[Int], f: (Int) => Boolean): List[Int] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    val isHead = f(head)
    if (isHead) head::filter(tail, f)
    else filter(tail, f)
  }
}

filter(List(0, 0, 2, 0, 0, 6), checkIfNumberIsBiggerThanZero)

// viii.
// takes last n-th elements of list // takeRight
def take(l: List[Int], i: Int): List[Int] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    if (l.length > i) take(tail, i)
    else head::take(tail, i)
  }
}

take(testList, 3)

// ix.
def drop(l: List[Int], i: Int): List[Int] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    if (head == i) drop(tail, i)
    else head::drop(tail, i)
  }
}

drop(testList, 5)

// x.
def contains(l: List[Int], i: Int): Boolean = {
  if (l == Nil) false
  else {
    val head::tail = l
    if (head == i) true
    else contains(tail, i)
  }
}

contains(testList, 6)
contains(testList, 8)

// xi.
def reverse(l: List[Int]): List[Int] = {
  if (l == Nil) Nil
  else {
    val head::tail = l
    reverse(tail):+head
  }
}

reverse(testList)