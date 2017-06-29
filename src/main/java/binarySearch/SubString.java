package binarySearch;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 3/2/2017.
 */
public class SubString {

    public int getIndexOfminimumLengthString(ArrayList<String> a) {
        Integer minimumLength = a.get(0).length();
        int arrayLength = a.size() - 1;
        int startIndex =0;

        for (int i = 0; i < arrayLength; i++) {
            if (minimumLength >= a.get(i).length()) {
                minimumLength = a.get(i).length();
                startIndex =i;
            }
        }
        return startIndex;
    }

    public boolean isMatching(ArrayList<String> a,String s){

        int arrayLength=a.size() - 1;
        int stringLength= s.length() -1;
        for(int i =0 ; i <= arrayLength ; i ++) {

            if (a.get(i).length()-1 < stringLength) {
                return false;
            } else {
                for (int j = 0; j <= stringLength; j++) {
                    if (a.get(i).charAt(j) != s.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String longestCommonPrefix(ArrayList<String> a) {

        int index= getIndexOfminimumLengthString(a);
        String minimumLengthString=a.get(index);
        int lengthOfMInimumLengthString=minimumLengthString.length() -1;
        int startIndex=0;
        int endIndex=lengthOfMInimumLengthString;
        StringBuilder subString= new StringBuilder();

        while(startIndex <= endIndex){
            int midIndex= (startIndex + endIndex) / 2;
            String substringOfMinimumLengthString=minimumLengthString.substring(startIndex,midIndex +1 );

            if(isMatching(a,subString.toString()+substringOfMinimumLengthString)){
                subString.append(substringOfMinimumLengthString);
                startIndex=midIndex + 1;
            } else{
                endIndex= midIndex -1;
            }
        }
        return subString.toString();
    }

    public static void main(String args[]){

        SubString obj= new SubString();
        ArrayList<String> als = new ArrayList<String>();
        als.add("abcdef");
        als.add("abcde");
        als.add("abcf");
        als.add("abcdefg");
        int length= obj.getIndexOfminimumLengthString(als);
        boolean descision= obj.isMatching(als,"dbc");

        String s= obj.longestCommonPrefix(als);
    }
}



