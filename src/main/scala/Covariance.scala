/**
  * Created by PSwain on 9/20/2016.
  */
class Creature {
  override def toString = "I exist"
}

class Person(val name: String) extends Creature {
  override def toString = name
}

class Employee(override val name: String) extends Person(name) {
  override def toString = name
}

class Test[T](val x: T = null) {

  def upperBound[U <: T](v: U): Test[U] = {
    new Test[U](v)
  }

  def lowerBound[U >: T](v: U): Test[U] = {
    new Test[U](v)
  }
}

object Main extends App {


  val test = new Test[Person]()

  val ub = test.upperBound(new Employee("John Derp")) //#1 ok because Employee is subtype of Person
  val lb = test.lowerBound(new Creature())            //#2 ok because Creature is supertype of Person

  //val ub2 = test.upperBound(new Creature())           //#3 error because Creature is not subtype of Person
  val lb2 = test.lowerBound(new Employee("Scala Jo")) //#4 ok? how could? as Employee is not supertype of Person
}