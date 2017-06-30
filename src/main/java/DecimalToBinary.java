/**
 * Created by PSwain on 2/17/2017.
 */
public class DecimalToBinary {

    public String findDigitsInBinary(int a) {
        StringBuffer s = new StringBuffer();

        if (a == 0)
        {
            s.append(0);
            return s.reverse().toString();
        }
        while(a >= 1){
            if(a == 1){
                s.append(a);
                a = a / 2 ;
            }else{
                int r= a%2;
                s.append(r);
                a = a / 2;
            }
        }
        return s.reverse().toString();
    }

    public static void main(String Args[]){
        new DecimalToBinary().findDigitsInBinary(0)   ;
        println("hi")
        println("merge conflict2")

    }
}
