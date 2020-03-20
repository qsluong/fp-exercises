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

// Recursion

// 1.
val people: List[String] = List("Alfred", "Boris", "Ann", "Jan", "Anya", "Monique", "Christophe", "Jan", "Joris", "Bert", "Olaf")

// i
val dearAppendedToPeople: List[String] = people.map(el => s"Dear $el")

// ii
def appendDearToString(s: String): String = {
  s"Dear $s"
}

def printElementsFromListWithFunction(l: List[String], f: (String) => String) = {
  l.foreach(el => println(f(el)))
}

printElementsFromListWithFunction(people, appendDearToString)


// iii.
val gobbleGook = "gobbleGook"
def charListFromString(s: String): List[Char] = s.toList
charListFromString(gobbleGook)

// iv.
def uniqueCharListFromString(s: String): List[Char] = {
  val charList = s.toList
  val uniqueCharList = charList.distinct
  uniqueCharList
}

uniqueCharListFromString(gobbleGook)

// v.
def countTotalSizeOfElements(l: List[String]): Int = {
  var total = 0
  l.foreach(f => total += f.length)
  total
}

countTotalSizeOfElements(people)


// vi.

val concatString = (s1: String, s2: String) => s1 + ", " + s2

def foldElements(l: List[String]): String = {
  val text = "Dear"
  val commas = l.fold("")(concatString)
  text + commas.substring(1)
}

foldElements(people)

// vii.
def countPatternInName(l: List[String], pattern: String): Int = {
  var count = 0
  l.foreach(el => if (el.toLowerCase.contains(pattern)) count += 1)
  count
}

countPatternInName(people, "an")

// viii.

val hasThreeChar: (String) => Boolean = (x: String) => if (x.length == 3) true else false

def countAmountThreeCharStringInList(l: List[String]): Int = {
  var count = 0
  l.foreach(el => if (hasThreeChar(el)) count += 1)
  count
}

countAmountThreeCharStringInList(people)

// ix.

val stringContainsCapitalLetter: (String) => Boolean = (x: String) => {
  val charList = x.toList
  var containsCapital = false
  for (i <- charList) {
    if (i == i.toUpper) containsCapital = true
  }
  containsCapital
}

def checkIfNameContainCapitalLetter(l: List[String]) = {
  l.forall(p => stringContainsCapitalLetter(p))
}

checkIfNameContainCapitalLetter(people)

// x.
val stringContainsPattern: (String, List[Char]) => Boolean = (s: String, pattern: List[Char]) => {
  var containsPattern = false
  for (c <- pattern) {
    if (s.contains(c)) containsPattern = true
  }
  containsPattern
}

val pattern: List[Char] = "yq".toList

def checkIfNameContainsPattern(l: List[String]) = {
  l.exists(p => stringContainsPattern(p, pattern))
}

checkIfNameContainsPattern(people)

// xi.

def printIfNameContainsPattern(l: List[String]) = {
  l.foreach(s => if (stringContainsPattern(s, pattern)) println(s))
}

printIfNameContainsPattern(people)

// xii.
def groupByStringSize(l: List[String]) = {
  l.groupBy(name => name.length)
}

groupByStringSize(people)

// xiii.
def checkIfListContainsDuplicates(l: List[String]) = {
  if (l.size > l.distinct.size) true
  else false
}

checkIfListContainsDuplicates(people)