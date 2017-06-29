import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by PSwain on 2/18/2017.
 */
public class PrimeSum  {
    public class PrimeNumberTuples implements  Comparable<PrimeNumberTuples>{
        Integer first;
        Integer second;
        public int compareTo(PrimeNumberTuples o) {

            if(this.first == o.first){
                return this.second.compareTo(o.second);
            } else{
                return this.first.compareTo(o.first);
            }
        }
    }

    public boolean isPrime(int number){
        if ( number== 2 ){
            return true;
        }
        if ( number == 1){
            return false;
        }
        int i = 2;
        while(i <= Math.sqrt(number)){
            if(number % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
    public ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 2; i <= a ; i++){
            if(isPrime(i)){
                al.add(i);
            }
        }
        return al;
    }

    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> ret= new ArrayList<Integer>();
        ArrayList<Integer> al= sieve(a/2);
        Iterator<Integer> itr = al.iterator();
        ArrayList<PrimeNumberTuples> pts = new ArrayList<PrimeNumberTuples>();


        while(itr.hasNext()){
            int value= itr.next();
            if(isPrime(a - value)){
                PrimeNumberTuples pt = new PrimeNumberTuples();
                pt.first=value;
                pt.second= a-value;
                pts.add(pt);
            }
        }

        PrimeNumberTuples p =Collections.min(pts);
        ret.add(p.first);
        ret.add(p.second);

        return ret;

    }

    public static void main(String args[]){
        new PrimeSum().primesum(184);

    }



}
