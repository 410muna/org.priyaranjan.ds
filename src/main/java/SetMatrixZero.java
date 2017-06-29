import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 2/9/2017.
 */
public class SetMatrixZero {




    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rowLength=a.size();
        int columnLength=a.get(0).size();

        //Identify the points which stores zeros
        ArrayList<String> zeroPointStore = new ArrayList<String>();
        for(int rowCount=0 ; rowCount < rowLength ; rowCount ++){
            for(int columnCount=0 ; columnCount < columnLength;columnCount++){
                if(a.get(rowCount).get(columnCount) == 0){
                    zeroPointStore.add(rowCount + "," + columnCount );
                }
            }
        }

        //trverse the zeroPointStore and set zeros to corrosponding rows and columns

        Iterator<String> zeroPointStoreItr = zeroPointStore.iterator();
        while(zeroPointStoreItr.hasNext()){
            String zeroPoint=zeroPointStoreItr.next();
            int rowNumber=Integer.parseInt(zeroPoint.split(",")[0]);
            int columnNumber=Integer.parseInt(zeroPoint.split(",")[1]);

            //making all element of row zero
            for(int columnCount=0;columnCount < columnLength;columnCount ++){
                a.get(rowNumber).set(columnCount,0) ;
            }

            //making all element of column zero
            for(int rowCount=0;rowCount < rowLength;rowCount ++){
                a.get(rowCount).set(columnNumber,0) ;
            }
        }

    }


    public static void main(String args[]){

        ArrayList<ArrayList<Integer>> inputMatrix= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1= new ArrayList<Integer>();
        row1.add(1);
        row1.add(0);
        row1.add(1);

        ArrayList<Integer> row2= new ArrayList<Integer>();
        row2.add(0);
        row2.add(1);
        row2.add(1);

        ArrayList<Integer> row3= new ArrayList<Integer>();
        row3.add(1);
        row3.add(1);
        row3.add(1);

        inputMatrix.add(row1);
        inputMatrix.add(row2);
        inputMatrix.add(row3);

        new SetMatrixZero().setZeroes(inputMatrix);
    }
}
