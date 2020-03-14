val l = 1::2::3::4::Nil
val ll = 1::(2::(3::(4::Nil)))

val head :: tail = l

def complexFunc() = {
  val status = 200
  val message = "body"

  (status, message)
}

val (s, m) = complexFunc()