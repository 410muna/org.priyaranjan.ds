/**
  * Created by PSwain on 9/6/2016.
  */
object PartialApplication {

  def partial1[A,B,C] (a:A,f: (A,B) => C) : B => C  =  {

    b : B => (f(a,b))

  }

}
