/**
 * Created by PSwain on 2/20/2017.
 */
public class IsPalindrom {


    public boolean isPalindrome(int a) {
        String s = String.valueOf(a);
        int length= s.length();
        int frontPtr=0;
        int endPtr=length-1;
        while(true){
            if(frontPtr == endPtr || (frontPtr + 1) == endPtr ){
                int k = (a / (int) java.lang.Math.pow(10,frontPtr)) % 10;
                int l= (a / (int) java.lang.Math.pow(10,endPtr)) % 10;
                if (k == l){
                    return true;
                } else{
                    return false;
                }
            } else{
                int k = (a / (int) java.lang.Math.pow(10,frontPtr)) % 10;
                int l= (a / (int) java.lang.Math.pow(10,endPtr)) % 10;
                if (k != l){
                    return false;
                }

            }

            frontPtr ++;
            endPtr --;
        }
    }

    public static void main(String args[]){
        new IsPalindrom().isPalindrome(23132);

    }
}
