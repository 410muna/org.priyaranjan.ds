/**
 * Created by PSwain on 2/15/2017.
 */
public class MathBug_01 {


        public int isPrime(int A) {
            int upperLimit = (int)(Math.sqrt(A));
            if (A == 1) return 0;
            for (int i = 2; i <= upperLimit; i++) {
                if (i < A && A % i == 0) return 0;

            }
            return 1;
        }

    public static void main(String args[]){

        System.out.println(new MathBug_01().isPrime(1));
    }

}
