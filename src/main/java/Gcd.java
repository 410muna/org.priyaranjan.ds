/**
 * Created by PSwain on 2/19/2017.
 */
public class Gcd {

    public int gcd(int a, int b) {

        if (a ==0) {
            return b;
        }

        if (b ==0) {
            return a;
        }

        while( a != b){
            if ( a > b ){
                int c = a-b;
                a =c ;
            } else{
                int c = b-a;
                b=c;
            }
        }
        return a;
    }

    public static void main( String args[]){
        new Gcd().gcd(0,0);
    }
}
