import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 2/21/2017.
 */
public class ArrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int length=a.size();
        System.out.println(a.get(2));
         int i=0;
         while(i < length){
             int currValue = a.get(i);
             int otherValue = a.get(currValue);
             int old = otherValue % length;
             int ne = otherValue / length;
             a.remove(i);
             a.add(i,currValue + old*length);
             i++;
         }
        i=0;
        while(i < length){
            int currValue = a.get(i);
            int ne = currValue / length;
            a.remove(i);
            a.add(i,ne);
            i++;
        }
    }

    public static void main(String args[]){

        ArrayList<Integer> al = new ArrayList<Integer>();

        al.add(4);
        al.add(0);
        al.add(2);
        al.add(1);
        al.add(3);
        new ArrangeArray().arrange(al);
    }
}

