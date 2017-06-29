package binarySearch;

/**
 * Created by PSwain on 2/22/2017.
 */
public class Sqrt {

    public int sqrt(int a) {

        double startIndex = 0;
        double endIndex = a;

        while (startIndex <= endIndex) {
            double midIndex = (startIndex + endIndex) / 2;
            if (java.lang.Math.floor(midIndex * midIndex) == a) {
                return (int)(java.lang.Math.floor(midIndex));
            } else if(midIndex * midIndex < a ){
                startIndex=midIndex;
            }else{
                endIndex=midIndex;
            }
        }
        return -1;
    }

    public static void main(String args[]){

        new Sqrt().sqrt(1200);
    }
}
