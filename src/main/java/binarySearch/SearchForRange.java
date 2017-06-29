package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PSwain on 3/2/2017.
 */
public class SearchForRange {
    public int binarySearchLeft(List<Integer> a,int n){
        int startPointer = 0;
        int endPointer = a.size()-1;
        int min = -1;
        while(startPointer <= endPointer ){
            int middlePointer = (startPointer + endPointer) / 2;
            if (a.get(middlePointer) == n){
                min=middlePointer;
                endPointer = middlePointer -1;
            } else if (a.get(middlePointer) > n){
                endPointer = middlePointer -1;
            }else{
                startPointer = middlePointer + 1;
            }
        }
        return min ;
    }

    public int binarySearchRIght(List<Integer> a,int n){
        int startPointer = 0;
        int endPointer = a.size()-1;
        int max = -1;
        while(startPointer <= endPointer ){
            int middlePointer = (startPointer + endPointer) / 2;
            if (a.get(middlePointer) == n){
                max=middlePointer;
                startPointer = middlePointer + 1;
            } else if (a.get(middlePointer) > n){
                endPointer = middlePointer -1;
            }else{
                startPointer = middlePointer + 1;
            }
        }
        return max ;
    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> ai=  new ArrayList<Integer>();
        // Finding minimum , then we have to get along deliberately left side
        int min =binarySearchLeft(a,b);
        int max=binarySearchRIght(a,b);
        ai.add(min);
        ai.add(max);
        return ai;
    }

    public static void main(String args[]){
        List<Integer> li = new ArrayList<Integer>() ;

        li.add(5);
        li.add(7);
        li.add(6);
        li.add(8);
        li.add(8);
        li.add(8);
        li.add(10);
        li.add(10);

       int k = new SearchForRange().binarySearchRIght(li,1);
    }

}
