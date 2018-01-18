//import com.typesafe.config.ConfigException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 1/30/2017.
 */
public class ArrayRotation {
    ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int c =  B % A.size();

        if(c == 0){
            return A;
        }
        for (int i = 0 ; i < A.size() - c ; i++) {
            ret.add(A.get(i + c));
        }

        for( int i = 0 ; i < c ; i++){
            ret.add(A.get(i));
        }
        return ret;
    }


    public static  void main(String args[]){
        ArrayList<Integer> ar= new ArrayList<Integer>();
        ar.add(1);
        //ar.add(2);
        //ar.add(3);
        //ar.add(4);
        Iterator<Integer> i = new ArrayRotation().rotateArray(ar,3).iterator();
        while( i.hasNext()){
            System.out.println(i.next());
        }

    }
}



