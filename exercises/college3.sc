def teachersNeededFor(numbersOfStudents: Int): Int = {
  if (numbersOfStudents <= 30) 1
  else 1 + teachersNeededFor(numbersOfStudents - 30)
}

teachersNeededFor(20)
teachersNeededFor(45)
teachersNeededFor(163)
// StackOverflow
//teachersNeededFor(1000000)

