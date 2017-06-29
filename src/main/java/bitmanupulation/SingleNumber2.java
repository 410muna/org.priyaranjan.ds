package bitmanupulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by PSwain on 4/18/2017.
 */
public class SingleNumber2 {

    public int singleNumber(final List<Integer> a) {

        StringBuilder s = new StringBuilder();
        Iterator<Integer> itr = a.iterator();
        int[] ones = new int[32];
        int[] zeros = new int[32];
        while(itr.hasNext()){

            Integer i = itr.next();
            String str  = Integer.toString(i,2);
            char[] ch=str.toCharArray();
            int size= ch.length;
            int k = size-1;
            while( k >= 0){
                if( (ch[k]) == '1' ){
                        ones[ (size-1) - k ]= ones[(size-1) -k ] + 1;
                }else{
                    zeros[(size-1) - k  ]= zeros[(size-1) -k ] + 1;
                }
                k--;
            }
        }

        int l =31;
        while(l >= 0){
            if(ones[l] % 3 > 0){
                s.append("1");
            }else{
                s.append("0");
            }

            l--;
        }
        return Integer.parseInt(s.toString(), 2);
    }

    public static void main(String Args[]){

        List<Integer> l = new ArrayList<Integer>();

        l.add(2);
        l.add(2);
        l.add(2);
        l.add(12);
        l.add(12);
        l.add(12);
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(5);
        int k = new SingleNumber2().singleNumber(l);
        System.out.println(k);
    }
}
