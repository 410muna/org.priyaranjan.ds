import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by PSwain on 2/13/2017.
 */

public class FactorsOfANumber {

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int i = 1;
        while(i <= Math.sqrt(a)){
            if(a % i == 0){
                al.add(i);
                if(i != Math.sqrt(a)){
                    al.add(a/i);
                }
            }
            i++;
        }
         Collections.sort(al);
         return al;
    }

    public static void main(String args[]){

        new FactorsOfANumber().allFactors(1);

    }
}
