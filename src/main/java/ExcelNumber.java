import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * Created by PSwain on 2/20/2017.
 */


public class ExcelNumber {
    public enum Alphabet {
        A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8), I(9), J(10), K(11), L(12), M(13), N(14), O(15), P(16), Q(17), R(18), S(19), T(20), U(21), V(22), W(23), X(24), Y(25), Z(26);
        private int value;

        private Alphabet(int value) {
            this.value = value;
        }
    }
    public int titleToNumber(String a) {
           int titleLength= a.length();
           char [] titleCharacters =a.toCharArray();
           Double number=0.0;

           for( int i =0 ; i < titleLength ; i++){
                int value = Alphabet.valueOf(String.valueOf(titleCharacters[i])).value;
                Double place=java.lang.Math.pow(Double.parseDouble(String.valueOf(26)),titleLength - Double.parseDouble(String.valueOf(i)) -1);
                number = number + value*place;
           }

        return number.intValue();

    }



    public static void main(String arg[]) {

        System.out.println(new ExcelNumber().titleToNumber("ABBB"));
        //System.out.println(Alphabet.A.value);
    }

}
