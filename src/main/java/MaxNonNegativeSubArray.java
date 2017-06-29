import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by PSwain on 2/7/2017.
 */
public class MaxNonNegativeSubArray {

    public class Range implements Comparable<Range>{
        int startIndex;
        int endIndex;
        double sum;
        int numElements;
        Range(int start,int end){
            startIndex=start;
            endIndex=end;
            numElements=end -start +1;
        }
        public int compareTo(Range o) {
            if (this.sum > o.sum || this.sum < o.sum){
                if ( -(this.sum - o.sum) < 0){
                    return -1;
                } else{
                    return  1;
                }

            }else if (this.numElements > o.numElements || this.numElements < o.numElements) {
                return -(this.numElements - o.numElements);
            }else{
                return (this.startIndex - o.endIndex );
            }
        }
    }

   // public  int sum(List<Integer> subList){

    //}
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        Iterator<Integer> itr= a.iterator();
        ArrayList<Range> al= new ArrayList<Range>();
        int count=0;
        int i =0;
        int j =0;
        while(itr.hasNext()){
            int value=itr.next();
            if( value >= 0){
                if (a.size()-1 == j){ // if we found a + number at the end of the list
                    al.add(new Range(i,j));
                }
                j++;
            } else{
                if( j-1 >= i) { //if it is actually a range
                    al.add(new Range(i, j - 1));
                }
                i=j+1;
                j=j+1;
            }
        }

        Iterator<Range> rangeIterator= al.iterator();

        while(rangeIterator.hasNext()){
            Range rangeVal=rangeIterator.next();
            rangeVal.sum=sum(a,rangeVal.startIndex,rangeVal.endIndex);
            //System.out.println(a.subList(rangeVal.startIndex,rangeVal.endIndex));

            //a.subList(rangeVal.startIndex,rangeVal.endIndex).add(15);
        }

        ArrayList<Integer> retArray= new ArrayList<Integer>();
        if (! al.isEmpty()){
            Range maxRange= Collections.min(al);
            int st=maxRange.startIndex;
            int end=maxRange.endIndex;

            for (int k=st;k <= end ;k++ ){
                retArray.add(a.get(k));
            }
        }



        //System.out.println(al.get(0).startIndex);


        return retArray;
    }

    /*private void sum(List<Integer> integers) {
    }*/

    public long sum(ArrayList<Integer> integers,int st,int end) {

        long sum=0;
        for (int i=st;i <= end ;i++ ){
            sum= sum + integers.get(i);
        }
        return  sum;
    }




    public static void main(String args[]){

    ArrayList<Integer> al = new ArrayList<Integer>();
       al.add(1159126505);
       al.add(-1632621729);
        al.add(1433925857);
        al.add(84353895);
        al.add(2001100545);
        al.add(1548233367);
        al.add(-1585990364 );
       /* al.add(-1);
       al.add(20);
        al.add(5);
        al.add(1);*/
        //al.add(3);
       ArrayList<Integer> nAl=  new MaxNonNegativeSubArray().maxset(al);
        Iterator<Integer> itr= nAl.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
