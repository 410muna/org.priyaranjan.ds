package binarySearch;

import java.util.ArrayList;

/**
 * Created by PSwain on 2/22/2017.
 */
public class BinarySearch {

    public int binarySearch(ArrayList<Integer> a,int n){

        int startPointer = 0;
        int endPointer = a.size()-1;

        while(startPointer <= endPointer ){
            int middlePointer = (startPointer + endPointer) / 2;
            if (a.get(middlePointer) == n){
                return middlePointer;
            } else if (a.get(middlePointer) > n){
                endPointer = middlePointer -1;
            }else{
                startPointer = middlePointer + 1;
            }
        }

        return -1;
    }

    public static void main(String args[]){

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(3);
        al.add(21);
        al.add(24);

        new BinarySearch().binarySearch(al,3);
    }

}
