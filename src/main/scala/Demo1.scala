/**
  * Created by PSwain on 5/19/2017.
  */
object Demo1  extends App{


  def sumOfArray(array : Array[Int]): Int ={

    var sum = 0
    val size=array.size
    for( i <- (size-1) to 0 ){

      sum=sum + array(i)
    }
   return sum

  }
  println(sumOfArray(Array(1,2,3,4,5)))
}
