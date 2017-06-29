import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by PSwain on 1/16/2017.
 */





    class Solution {
        // DO NOT MODIFY THE LIST

    public void upperRight(int x1, int y1,int x2, int y2,final List<ArrayList<Integer>> a,ArrayList<Integer> result){

        int i =0,j=0;
        //Row pilling
        for(i=y1;i <= y2;i++){
            result.add(a.get(x1).get(i));
            //System.out.print(a.get(x1).get(i));
        }
        //Column pilling
        for(j=x1+1;j <= x2;j++){
            result.add(a.get(j).get(y2));
            //System.out.print(a.get(j).get(y2));
        }


        if(x2-x1 > 0 && y2 - y1 > 0 ){
            lowerLeft(x1+1,y1,x2,y2-1,a,result);
        }
    }

    public void lowerLeft(int x1, int y1,int x2, int y2,final List<ArrayList<Integer>> a,ArrayList<Integer> result){

        int i =0,j=0;
        //Row pilling
        for(i=y2;i >= y1;i--){
            //System.out.println("");
            //System.out.print(a.get(x2).get(i));
            result.add(a.get(x2).get(i));
        }
        //Column pilling
        for(j=x2-1;j >= x1;j--){
            result.add(a.get(j).get(y1));
            //System.out.print(a.get(j).get(y1));
        }
        if(x2-x1 > 0){
            upperRight(x1,y1+1,x2-1,y2,a,result);
        }
    }


    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        upperRight(0,0,a.size()-1,a.get(0).size()-1,a,result); //upperRight(0,0,2,3,a,result);
        return result;
    }
        public ArrayList<Integer> spiralOrder1(final List<ArrayList<Integer>> a) {

            int flag  =0;
            ArrayList<Integer> result = new ArrayList<Integer>();
            Iterator<ArrayList<Integer>>  i = a.iterator();
            while(i.hasNext()){
                Iterator<Integer> i1;
                if(flag % 2 == 1){
                    ArrayList<Integer> al = i.next() ;
                    Collections.reverse(al);
                    i1 = al.iterator();
                }else {
                    i1 =i.next().iterator();
                }
                while(i1.hasNext()){
                    result.add(i1.next());
                }

                flag=flag+1;
            }
            return result;
        }
    }

public class SpiralMatrix {

    public static  void main(String args[]){


        //Integer[] a1= {1,2,3,4,5} ;
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(44);
       al.add(2);
       /* al.add(3);
        al.add(11); */

        ArrayList<Integer> bl = new ArrayList<Integer>();
        bl.add(36);
       /* bl.add(5);
        bl.add(6);
        bl.add(12); */

        ArrayList<Integer> cl = new ArrayList<Integer>();
        cl.add(395);
       /* cl.add(8);
        cl.add(9);
        cl.add(13); */
        ArrayList<Integer> dl = new ArrayList<Integer>();
        dl.add(179);
        ArrayList<Integer> el = new ArrayList<Integer>();
        el.add(249);
        ArrayList<Integer> fl = new ArrayList<Integer>();
        fl.add(349);
        ArrayList<Integer> gl = new ArrayList<Integer>();
        gl.add(5);
        ArrayList<Integer> hl = new ArrayList<Integer>();
        hl.add(139);

        List<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>() ;

        b.add(al);
       /* b.add(bl);
        b.add(cl);
        b.add(dl);
        b.add(el);
        b.add(fl);
        b.add(gl);
        b.add(hl); */


        // System.out.println(b.size());

       // System.out.println(b.get(0).get(0));
        Solution soln = new Solution();
       //soln.upperRight(0,0,2,3,b);
        //soln.lowerLeft(1,0,2,1,b);
        Iterator<Integer> k =soln.spiralOrder(b).iterator();
        System.out.println("Printing data");
        while(k.hasNext()){
            System.out.println(k.next());
        }

        //soln.spiralOrder(b);
        //Iterator<Integer> m=  soln.spiralOrder(b).iterator();
        //soln.spiralOrder(b).iterator().hasNext();
        //while(m.hasNext()){
          //  System.out.println(m.next());
        //}

    }







    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }



}













