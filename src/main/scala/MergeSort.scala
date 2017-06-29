/**
  * Created by PSwain on 1/25/2017.
  */

import scala.collection.mutable.ArrayBuffer;
object MergeSort extends App {


  /*
  Complexity is O(n)
   */
  def merge(left : ArrayBuffer[Int],right : ArrayBuffer[Int]): ArrayBuffer[Int] ={

    val mergedCollection=ArrayBuffer[Int]()
    var j=0
    var k =0
    val leftLength=left.length
    val rightLength=right.length
    for(i <- 1 to left.length + right.length){
      if((j != leftLength  && k != rightLength)) {
        if (left(j) <= right(k)) {
          mergedCollection += left(j)
          j = j + 1
        } else {
          mergedCollection += right(k)
          k = k + 1
        }
      } else{

        if(j < leftLength){
          mergedCollection += left(j)
          j= j+1
        }

        if(k < rightLength){
          mergedCollection += right(k)
          k= k+1
        }
      }
    }
    mergedCollection
  }

  def mergeSort(A : ArrayBuffer[Int] ): ArrayBuffer[Int] ={
    if(A.length <= 1)
      return A
    val mid=A.length/2
    val left=ArrayBuffer[Int]()
    val right=ArrayBuffer[Int]()
    for(i <- 0 to mid-1){
      left += A(i)
    }
    for(i <- mid to A.length -1){
      right += A(i)
    }
    val left1=mergeSort(left)
    val right1=mergeSort(right)
    merge(left1,right1)
  }

  mergeSort(ArrayBuffer(203)).foreach(println)
}
