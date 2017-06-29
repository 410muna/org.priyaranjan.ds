import java.util.ArrayList;

/**
 * Created by PSwain on 2/15/2017.
 */
public class SumOfSquares {




        public ArrayList<ArrayList<Integer>> squareSum(int A) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

            for (int a = 0; a * a < A; a++) {
                for (int b = 0; b * b < A; b++) {
                    if ( (a <= b) && (a * a + b * b == A)) {
                        ArrayList<Integer> newEntry = new ArrayList<Integer>();
                        newEntry.add(a);
                        newEntry.add(b);
                        ans.add(newEntry);
                    }
                }
            }
            return ans;
        }

    public static void main(String args[]) {

        new SumOfSquares().squareSum(5);
    }

}

