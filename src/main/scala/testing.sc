class P(name: String)
class E(_name: String, role: String) extends P(_name)

def testF[T <: P](x: List[T]): List[T] = x

val le = List(new E("Henry", "Boss"))
class Test[R <: E](l: List[R]) {
  def r[O <: P] (): List[O] = testF(l)
}




