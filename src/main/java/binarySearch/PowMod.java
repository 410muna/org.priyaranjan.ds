package binarySearch;

/**
 * Created by PSwain on 2/22/2017.
 */
public class PowMod {

    public int pow(int x, int n, int d) {

        System.out.println(java.lang.Math.pow((double) x,(double) n));

       double ans =  ((java.lang.Math.pow((double) x,(double) n) % d) + d ) % d;

        return (int)java.lang.Math.abs(ans);
    }

    public static void main(String args[]){

        System.out.println(new PowMod().pow(1,1,20));

        int res = -1;
        res %=20;
        System.out.println(res);

        System.out.println((-25 + 20 )% 20 );
    }
}
