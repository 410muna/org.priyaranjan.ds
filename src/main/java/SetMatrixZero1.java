import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 2/9/2017.
 */
public class SetMatrixZero1 {


    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rowLength=a.size();
        int columnLength=a.get(0).size();

        //Identify the points which stores zeros
        ArrayList<Integer> zeroPointRows = new ArrayList<Integer>();
        ArrayList<Integer> zeroPointColumns = new ArrayList<Integer>();


        //Identifying rows
        for(int rowCount=0 ; rowCount < rowLength ; rowCount ++){
            for(int columnCount=0 ; columnCount < columnLength;columnCount++){
                if(a.get(rowCount).get(columnCount) == 0){
                    zeroPointRows.add(rowCount);
                    break;
                }
            }
        }
        //Identifying columns
        for(int columnCount=0 ; columnCount < columnLength ; columnCount ++){
            for(int rowCount=0 ; rowCount < rowLength;rowCount ++){
                if(a.get(rowCount).get(columnCount) == 0){
                    zeroPointColumns.add(columnCount);
                    break;
                }
            }
        }

        Iterator<Integer> zeroPointRowsItr = zeroPointRows.iterator();
        while(zeroPointRowsItr.hasNext()){
            int row=zeroPointRowsItr.next();
            for(int i =0 ; i < columnLength ; i ++){
                a.get(row).set(i,0);
            }
        }

        Iterator<Integer> zeroPointColumnItr= zeroPointColumns.iterator();
        while(zeroPointColumnItr.hasNext()){
            int column=zeroPointColumnItr.next();
            for(int i = 0;i < rowLength ; i ++){
                a.get(i).set(column,0);
            }
        }




        //trverse the zeroPointStore and set zeros to corrosponding rows and columns




        /*Iterator<String> zeroPointStoreItr = zeroPointStore.iterator();
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
        } */

    }


    public static void main(String args[]){

        ArrayList<ArrayList<Integer>> inputMatrix= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1= new ArrayList<Integer>();
        row1.add(0);
        row1.add(0);
       // row1.add(1);

        ArrayList<Integer> row2= new ArrayList<Integer>();
        row2.add(1);
        row2.add(1);
       // row2.add(1);

        ArrayList<Integer> row3= new ArrayList<Integer>();
        row3.add(1);
        row3.add(0);
        row3.add(1);

        inputMatrix.add(row1);
        inputMatrix.add(row2);
       // inputMatrix.add(row3);

        new SetMatrixZero1().setZeroes(inputMatrix);
    }
}
