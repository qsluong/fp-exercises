def teachersNeededFor(numbersOfStudents: Int, res: BigInt = 0): BigInt = {
  // base case, stop condition, stop condition
  if (numbersOfStudents <= 30) res + 1
  else teachersNeededFor(numbersOfStudents - 30, res + 1)
}

teachersNeededFor(20)
teachersNeededFor(45)
teachersNeededFor(163)
// StackOverflow
teachersNeededFor(1000000)

