/**
  * Created by PSwain on 1/11/2017.
  */
/** Applies this partial function to the given argument when it is contained in the function domain.
  *  Applies fallback function where this partial function is not defined.
  *
  *  Note that expression `pf.applyOrElse(x, default)` is equivalent to
  *  {{{ if(pf isDefinedAt x) pf(x) else default(x) }}}
  *  except that `applyOrElse` method can be implemented more efficiently.
  *  For all partial function literals compiler generates `applyOrElse` implementation which
  *  avoids double evaluation of pattern matchers and guards.
  *  This makes `applyOrElse` the basis for the efficient implementation for many operations and scenarios, such as:
  *
  *  - combining partial functions into `orElse`/`andThen` chains does not lead to
  *    excessive `apply`/`isDefinedAt` evaluation
  *  - `lift` and `unlift` do not evaluate source functions twice on each invocation
  *  - `runWith` allows efficient imperative-style combining of partial functions
  *    with conditionally applied actions
  *
  *  For non-literal partial function classes with nontrivial `isDefinedAt` method
  *  it is recommended to override `applyOrElse` with custom implementation that avoids
  *  double `isDefinedAt` evaluation. This may result in better performance
  *  and more predictable behavior w.r.t. side effects.
  *
  *  @param  x       the function argument
  *  @param default  the fallback function
  *  @return   the result of this function or fallback function application.
  *  @since   2.10
  */

/**
  * 1. PartialFunction is same as a maths function , which is not defined for all the domain
  * 2. PartialFunction[A,B] extends Function[A,B] , in Scala all functions are one object having apply() in them
  * 3. apply is the notion of saying f applies to x
  * 4. any object having apply can also behave as a function
  * 5. PartialFunction trait has a isDefinedAt() , which says at which domain value it is defined and at which domain it is defined
  * 6. Caller has the responsibility to call isDefinedAt before calling the function
  * 7. Seq has a collect method for patialfunction , which does a check using isDefinedAt() [collect is just a substitute of map]
  * 8. lift is a function in partialFunction which will convert o/p of function to None !! coolio
  */

object PartialFunction extends App {

  val divider : PartialFunction[Int,Int] = {
    case d : Int if d != 0 => 42/d
  }
  println(divider.lift(0))

  val driver1 = new PartialFunction[Int,Int]{

    def apply(v1 : Int): Int  ={
      42/v1
    }
    def isDefinedAt(v1 : Int) = v1 != 0
  }
  println(driver1(0))

 // val ordFunction= new Function[Int,Int] {

    //def apply( a: Int ): Int = {

   // }
  //}
}



