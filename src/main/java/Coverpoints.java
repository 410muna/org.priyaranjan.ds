/**
 * Created by PSwain on 2/5/2017.
 */

//import com.typesafe.config.ConfigException;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;
public class Coverpoints {

   public  int findMinDistance(int x1,int y1,int x2,int y2){

       Integer neX= null;
       Integer neY=null;
       Integer offset = null;
       int xAxis= Math.abs(x2-x1);
       int yAxis=Math.abs(y2-y1);

       if(x1 != x2 && y1 != y2) {
           if (xAxis == yAxis) {
               neX = x2;
               neY = y2;
               offset = 0;
           } else if (xAxis < yAxis) {
               neX = x2;
               //System.out.println("New xAxis is x2 " + x2);
               if (y1 < y2) {
                   neY = y1 + xAxis;
               } else {
                   neY = y1 - xAxis;
               }
               offset = Math.abs(neY - y2);
               //System.out.println("New yAxis is " + neY);
           } else {
               neY = y2;
               //System.out.println("New yAxis is y2 " + y2);
               if (x1 < x2) {
                   neX = x1 + yAxis;
               } else {
                   neX = x1 - yAxis;
               }

               offset = Math.abs(neX - x2);
               //System.out.println("New xAxis is " + neX);
           }
           return Math.abs(x1 - neX) + offset;


       } else{
           return Math.abs((x2 - x1) + (y2 - y1));
       }

   }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int count=0;
        Integer sum = 0;
        Integer prevXcoordinate= null;
        Integer prevYcoordinate=null;
        Iterator xItr=X.iterator();
        Iterator yItr=Y.iterator();
        while(xItr.hasNext() && yItr.hasNext()){
            if (count == 0){
                prevXcoordinate= (Integer) xItr.next();
                prevYcoordinate=(Integer)yItr.next();
                count ++;
            }
            else{
                Integer curXcoordinate=(Integer) xItr.next();
                Integer curYcoordinate=(Integer) yItr.next();
                sum = sum +  findMinDistance(prevXcoordinate,prevYcoordinate,curXcoordinate,curYcoordinate);
                prevXcoordinate=curXcoordinate;
                prevYcoordinate=curYcoordinate;
            }
        }
        return sum;
    }
    public static void main(String args[]){

        ArrayList<Integer> X = new ArrayList<Integer>();
        X.add(0);
        X.add(1);
        X.add(1);
        ArrayList<Integer> Y = new ArrayList<Integer>();
        Y.add(0);
        Y.add(1);
        Y.add(2);

        int ret=  new Coverpoints().coverPoints(X,Y);
        System.out.println(ret);

    }
}
