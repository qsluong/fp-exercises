// 1
val swap = (tuple: (Int, String)) => (tuple._2, tuple._1)
swap((1, "Test"))

// 2
val doubleHead = (list: List[Int]) => list.map(_ * 2)
val l = List(1, 5, 6, 10)

doubleHead(l)

// 3
val add = (x: Int) => (y: Int) => x + y
add(3)(5)

// 4
val multiplyBy = (x: Int) => (y: Int) => x * y
multiplyBy(3)(5)

// 5
val applyFunc = (x: Int, y: Int, f:(Int, Int) => Int) => f(x, y)
val addFunc = (x: Int, y: Int) => add(x)(y)
val multiplyFunc = (x: Int, y: Int) => multiplyBy(x)(y)
applyFunc(3, 5, addFunc)
applyFunc(3, 5, multiplyFunc)

// 6
val sizeDescription = (l:List[Int]) => if (l.size < 10) "short" else if (l.size < 100) "long" else "very long"
val shortList: List[Int] = Nil
val longList: List[Int] = List.range(0, 10)
val veryLongList: List[Int] = List.range(0, 110)

sizeDescription(shortList)
sizeDescription(longList)
sizeDescription(veryLongList)

// 7
val lucky: Int => Int => String = (x:Int) => (y: Int) => if (x == y) "Lucky Number" else "Sorry, try again"
lucky(2)(2)
lucky(2)(5)

// 8
val zip = (a: List[Int], b: List[Int]) => a.zip(b)

zip(List(1,2,3), List(5,4,3))

// 9
val calculatePrice = (drinks: List[Int], price: List[Double], discount: (Int, Double) => Double) => {
  var total = 0.0
  for ((d, i) <- drinks.zipWithIndex) {
    total += discount(d, price(i))
  }
  total
}

val noDiscount = (x: Int, y: Double) => x * y
val tenPercentDiscount = (x: Int, y: Double) => (x * y) * 0.9
val happyHour = (x: Int, y: Double) => if (x % 2 == 0) (x / 2) * y else if (x == 1) x * y else ((x / 2) + 1)  * y

calculatePrice(List(2, 3), List(3.0, 2.5), noDiscount)
calculatePrice(List(2, 3), List(3.0, 2.5), tenPercentDiscount)
calculatePrice(List(3, 1), List(3.0, 2.5), happyHour)