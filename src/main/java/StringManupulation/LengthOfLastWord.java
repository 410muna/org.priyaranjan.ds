package StringManupulation;

/**
 * Created by PSwain on 4/17/2017.
 */
public class LengthOfLastWord {


        public int lengthOfLastWord(final String a) {

            int length = 0;
            String[] arr =  a.split(" ");
            int size= arr.length;

            if(size > 0 && arr[size - 1].trim().length() > 0 ){
                length = arr[size - 1].length();
            }
            return length;

    }





    public static void main(String Args[]){
       int k = new LengthOfLastWord().lengthOfLastWord(" ");
        System.out.println(k);
    }
}
