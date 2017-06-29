import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 2/11/2017.
 */
public class FirstMissingPositiveInteger {


    public int firstMissingPositive(ArrayList<Integer> a) {
        int arraySize=a.size();
        /*loop through the a and there are 3 scenarios
         1. if any number <= 0 or > N then discard them as they cab never be the desired smallest + integer, place a 0 in their place
         2. if any number with in range [1 , N] then swap them with appropriate index .
         
          */
        int retValue=-1;
        Iterator<Integer> itr= a.iterator();
        int indexCount = 0;

        while(itr.hasNext()){
            int value=itr.next();
            if(value <= 0 || value > arraySize){
                a.set(indexCount,arraySize+1);
            }
            indexCount ++;
        }

        itr= a.iterator();
        while( itr.hasNext()){
            int value=itr.next();
            if(Math.abs(value) != arraySize + 1){
                a.set(Math.abs(value)-1,-(Math.abs(a.get(Math.abs(value)-1))));
            }
        }

        indexCount=0;
        itr= a.iterator();
        while(itr.hasNext()){
            int value= itr.next();
            if(value > 0){
                retValue=indexCount + 1;
                break;
            }
            indexCount = indexCount + 1;
        }
        if (retValue == -1){
            retValue = arraySize + 1;
        }

        return  retValue;
    }

    public static void main( String args[]){

        FirstMissingPositiveInteger fmi=new FirstMissingPositiveInteger();
        ArrayList<Integer> al= new ArrayList<Integer>();
        al.add(-3);
        al.add(-1);
        al.add(-2);
        al.add(-1);
        System.out.println(fmi.firstMissingPositive(al));


    }
}
