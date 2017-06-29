/**
  * Created by PSwain on 9/6/2016.
  */
object PolyMerphicFunction {

  def isShorted[A](numbers : Array[A], gt: (A,A) => Boolean): Array[A]  ={
    numbers.sortWith(gt)
  }

  def main(args: Array[String]) {
    val nums= Array(1,2,12,10,8,3)
    isShorted[Int](nums,(x,y) => x > y).foreach(println)
  }

}
