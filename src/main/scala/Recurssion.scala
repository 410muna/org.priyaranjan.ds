import scala.annotation.tailrec

/**
  * Created by PSwain on 9/2/2016.
  */
object Recurssion {

  def fibbonaciSeries(n : Int): Int ={

    @tailrec
    def go(prev:Int,curr:Int,iteration:Int,n:Int): Int ={

      if (iteration == n)
        return curr + prev
      else
        return go(curr,curr+prev,iteration+1,n)
    }

    go(0,1,1,n)

  }
  def main(args: Array[String]) {

    println(Recurssion.fibbonaciSeries(5))
  }

}



