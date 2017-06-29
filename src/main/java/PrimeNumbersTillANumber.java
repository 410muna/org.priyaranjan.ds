import java.util.ArrayList;

/**
 * Created by PSwain on 2/18/2017.
 */
public class PrimeNumbersTillANumber {

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

    public static void main(String argrs[]){
        new PrimeNumbersTillANumber().sieve(7);

    }
}
