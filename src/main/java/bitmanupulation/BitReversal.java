package bitmanupulation;

/**
 * Created by PSwain on 5/8/2017.
 */
public class BitReversal {

    public long reverse(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;

    }


    public static void main(String args[]){







   }
}
