// Basics

// 1
3

// 2
val rootOfThree = math.sqrt(3)
val rootOfResultOfRootThree = math.sqrt(math.sqrt(3))
val difference = rootOfResultOfRootThree - rootOfThree

// 3
// var is assignable
var myNumber = 3
myNumber = 4

// val is not assignable
val myNumberVal = 3
//myNumberVal = 4

// 4
// res are val
// res0 = 10

// 5
// concatenate string by n-amount
val n = 3
"Avans" * n

// 6
// compares two values
// if n > m then return n else return m
8 max 9
8 max 7

// Functions

// 7
def succ(x:Int): Int = x + 1
succ(8)

// 8
def max(x: Int, y: Int): Int = x max y
max(8, 9)
max(8, 7)

// 9
def doubleMe(x: Int): Int = x + x
doubleMe(8)

// 10
def doubleUs(x: Int, y: Int): Int = doubleMe(x) + doubleMe(y)
doubleUs(8, 9)

// 11
def doubleSmallNumber(x: Int): Int = {
  if (x > 100) x
  else doubleMe(x)
}

doubleSmallNumber(101)
doubleSmallNumber(99)

