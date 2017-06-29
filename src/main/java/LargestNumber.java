import java.util.*;

/**
 * Created by PSwain on 2/13/2017.
 */
public class LargestNumber {

    public class IntegerComparator implements Comparator{

        public int compare(Object i1, Object i2) {
            Integer firstNumber= (Integer) i1;
            Integer secondNumber=(Integer) i2;
            Long firstLastConcat= Long.parseLong(firstNumber.toString() + secondNumber.toString());
            Long lastFirstConcat= Long.parseLong(secondNumber.toString() + firstNumber.toString());

            if(firstLastConcat > lastFirstConcat ){
                return -1;
            }else if(firstLastConcat < lastFirstConcat){
                return 1;
            }else {
                return 0;
            }
        }
    }

    public String largestNumber (final List<Integer> a) {
        IntegerComparator ic = new LargestNumber() .new IntegerComparator();
        Collections.sort(a,ic);
        StringBuffer ret= new StringBuffer();
        int count =0 ;
        int zeroRemovalFlag=0;

        Iterator<Integer> itr=  a.iterator() ;
        while(itr.hasNext()){
            Integer val= itr.next();
            if (count == 0 ){ //&& val != 0 &&  zeroRemovalFlag != 0 ){
                if( val != 0) {
                    ret.append(val.toString());
                    count = 1;
                    zeroRemovalFlag=1;
                }
            } else{
                ret.append(val.toString()) ;
            }

        }

        if(ret.toString().length() == 0){
            return "0";
        } else return ret.toString();

    }

    public static void main(String args[]){
       final ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(0);
        al.add(23);
        //al.add(0);
        //al.add(1);
        //al.add(0);
         LargestNumber ic = new LargestNumber() ;
        String op = ic.largestNumber(al);
        System.out.println(op);
    }
}
