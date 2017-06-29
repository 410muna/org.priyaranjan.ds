/**
  * Created by PSwain on 9/8/2016.
  */
package com
sealed trait List[+A]  // Covariant
case object Nil extends List[Nothing] //Singleton ro represent Nil in list
case class Cons[+A](head: A, tail: List[A]) extends List[A]
//case object N1 extends Nothing
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  //@Tailrecursive
  def rightFold[A,B](xs:List[A],z:B)(f:(A,B) => B ): B = xs match {

    case Nil => z
    case Cons(x,xs) => f(x,rightFold(xs,z)(f))
  }

  def sum1(l:List[Int]) =  rightFold(l,0.0)(_ + _)
  def product1(l:List[Int]) = rightFold(l,1)(_ *_)

  def length[A](l: List[A]): Int = rightFold(l,0)(( _ , y)  => 1 + y )


    /*l match {

    case Nil => 0
    case Cons(x,xs) => 1 + length(xs)
  }*/


  def drop[A](xs :List[A],n:Int) : List[A] ={

    def tail[A](xs:List[A]) : List[A] = xs match  {

      case Nil => Nil
      case Cons(x,xs) => xs

    }

    def go(xs: List[A],counter :Int): List[A]= {

      if (n <= 0){
        xs
      }
      else if (counter == n ){
        tail(xs)
      }
       else
        go(tail(xs),counter +1)
    }
    go(xs,1)

  }

def dropWhile[A](xs:List[A],f: A => Boolean): List[A] ={

  def go(xs : List[A]) : List[A] = xs match {

    case Nil => Nil
    case Cons(x,xs) => if (f(x)) {xs } else {go(xs)}
  }

   go(xs)
}

  def setHead[A](y:A,xs:List[A]): List[A]= xs match {

    case Nil => Cons(y,Nil)
    case Cons(x,xs) => Cons(y,xs)

  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

  def init[A](xs:List[A]): List[A] = xs match{ // This wont be a data sharing as we are building a new cons object for each element of the list

    case Nil => sys.error("List is empty")
    case Cons(_,Nil) => Nil
    case Cons(x,xs) => Cons(x,init(xs))
  }
  /*def printHead[A](xs :List[A]) : A =  xs match {

    case Nil => N1
    case Cons(x,xs) => x
  }*/
  def apply[A](as: A*): List[A] = // variadic function , so any 1,2,3,4,5 will be concerted into as : Seq[A]
    if (as.isEmpty) Nil
    //else Cons(as.head, apply(as.tail: _*))
    else Cons(as.head,List(as.tail:_*)) // variadic function here one sequence can be changed to variadic argument by _* operator
   //Read this for better understanding http://alvinalexander.com/scala/how-to-define-methods-variable-arguments-varargs-fields
   // val example = Cons(1, Cons(2, Cons(3, Nil)))
    //val example2 = List(1,2,3)
    //val total = sum(example)
}





object test {

  def printList[A](xs : List[A]): Unit = xs match {
    case Nil => println("")
    case Cons(x,xs) => println(x);printList(xs)
  }

  def main(args: Array[String]) {
    val list1 = com.List(1,2,3,4,6,7)
    println(List.sum(list1))
    //List.tail(list1)
    //printList(List.tail(list1))

    printList(List.drop(list1,1))
    printList(List.dropWhile(list1, (x:Int) => x == 6))
    println("printing o/p of setHead")
    printList(List.setHead(8,list1))
    println(List.product1(list1))
    println(List.sum1(list1))
    printList(List.rightFold(List(1,2,3),Nil:List[Int])(Cons(_,_)))

  }

}


