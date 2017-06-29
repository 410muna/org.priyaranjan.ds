import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by PSwain on 2/5/2017.
 */

class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }




public class OverLap {


        /*public int binarySearch(ArrayList<Interval> Is,Interval I,int startIndex ,int endIndex) {
            if(Is.isEmpty()){
                return -1;
            }
            int midIndex=(startIndex + endIndex)/2;
            if (I.start  Is.get(midIndex).start < ){
                return binarySearch(Is,I,midIndex+1,endIndex);
            } else{
                return binarySearch(Is,I,startIndex,midIndex-1);
            }


            return 1;
        } */
        //public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> Is = new ArrayList<Interval>();
            Is.add(newInterval);
            Iterator<Interval> intervalIter= intervals.iterator();

            while(intervalIter.hasNext()){
                Interval oldInterval=intervalIter.next();
                int oldStart=Is.get(Is.size()-1).start;
                int oldEnd=Is.get(Is.size()-1).end;
                int newStart=oldInterval.start;
                int newEnd=oldInterval.end;

                if(oldStart <= newStart && oldEnd >= newEnd ){
                    //System.out.println("Old covers new");

                } else if(oldStart >= newStart && oldEnd <= newEnd){
                    //System.out.println("New covers old");
                    Is.remove(Is.size()-1);
                    Is.add(oldInterval);
                } else if(oldStart <= newStart &&  oldEnd >= newStart && oldEnd <= newEnd ){
                    Is.remove(Is.size()-1);
                    Is.add(new Interval(oldStart,newEnd));
                   // System.out.println("Old first and overlaps new");
                } else if(newStart <= oldEnd && oldStart <= newEnd && newEnd <= oldEnd){
                    Is.remove(Is.size()-1);
                    Is.add(new Interval(newStart,oldEnd));
                    //System.out.println("New first and overlaps old");
                } else {
                    //System.out.println("No overlaping");
                    if(oldEnd < newStart){
                        Is.add(oldInterval);
                    }else{
                        Interval temp =Is.get(Is.size()-1);
                        Is.remove(Is.size()-1);
                        Is.add(oldInterval);
                        Is.add(temp);
                    }
                }
            }

            return Is;


        }




    public static void main(String args[]){

        ArrayList<Interval> al = new ArrayList<Interval>();
        al.add(new Interval(1,2));
        al.add(new Interval(3,5));
        al.add(new Interval(6,7));
        al.add(new Interval(8,10));
        al.add(new Interval(12,16));

        new OverLap().insert(al,new Interval(4,9));

    }


}
