package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PSwain on 3/1/2017.
 */
public class RotatedSortArray {
    // Function is used to find minimum element in the rotated sorted Aarry
    public int findMinimumElement(List<Integer> a){
        int startPointer=0;
        int endPointer=a.size()-1;

        while(endPointer - startPointer > 1){

            int midPointer= (endPointer + startPointer) /2;
            if (a.get(midPointer) > a.get(endPointer)){
                startPointer = midPointer;
            } else{
                endPointer = midPointer;
            }
        }
            if(a.get(startPointer) > a.get(endPointer)){
                return endPointer;
            }else return startPointer;
    }

    public int binarySearch(List<Integer> a,int b,int c,int n){

        int startPointer = b;
        int endPointer = c;

        while(startPointer <= endPointer ){
            int middlePointer = (startPointer + endPointer) / 2;
            if (a.get(middlePointer) == n){
                return middlePointer;
            } else if (a.get(middlePointer) > n){
                endPointer = middlePointer -1;
            }else{
                startPointer = middlePointer + 1;
            }
        }

        return -1;
    }

    public int search(final List<Integer> a, int b) {
        int minimumValueIndex= findMinimumElement(a);
        int maxIndexValue=a.size()-1;
        int indexValue= binarySearch(a,0,minimumValueIndex-1,b);
        int searchIndex = -1;
        if (indexValue != -1){
            return indexValue;
        }
        indexValue= binarySearch(a,minimumValueIndex,maxIndexValue,b);
        if (indexValue != -1){
            return indexValue;
        }
        return searchIndex;
    }

    public static void main(String args[]){
        List<Integer> li = new ArrayList<Integer>() ;

      /*  li.add(4);
        li.add(5);
        li.add(6);
        li.add(7);
        li.add(8);
        li.add(0);
        li.add(2);
        li.add(3); */

        li.add(111   );
        li.add(19    );
        li.add(20    );
        li.add(21    );
        li.add(22    );
        li.add(28    );
        li.add(29    );
        li.add(32    );
        li.add(36    );
        li.add(39    );
        li.add(40    );
        li.add(41    );
        li.add(42    );
        li.add(43    );
        li.add(45    );
        li.add(48    );
        li.add(49    );
        li.add(51    );
        li.add(54    );
        li.add(55    );
        li.add(56    );
        li.add(58    );
        li.add(60    );
        li.add(61    );
        li.add(62    );
        li.add(65    );
        li.add(67    );
        li.add(69    );
        li.add(71    );
        li.add(72    );
        li.add(74    );
        li.add(75    );
        li.add(78    );
        li.add(81    );
        li.add(84    );
        li.add(85    );
        li.add(87    );
        li.add(89    );
        li.add(92    );
        li.add(94    );
        li.add(95    );
        li.add(96    );
        li.add(97    );
        li.add(98    );
        li.add(99    );
        li.add(100   );
        li.add(105   );
        li.add(107   );
        li.add(108   );
        li.add(109   );
        li.add(110   );
        li.add(112   );
        li.add(113   );
        li.add(115   );
        li.add(117   );
        li.add(118   );
        li.add(119   );
        li.add(120   );
        li.add(121   );
        li.add(122   );
        li.add(123   );
        li.add(124   );
        li.add(125   );
        li.add(126   );
        li.add(128   );
        li.add(130   );
        li.add(131   );
        li.add(133   );
        li.add(134   );
        li.add(135   );
        li.add(136   );
        li.add(137   );
        li.add(138   );
        li.add(139   );
        li.add(141   );
        li.add(142   );
        li.add(144   );
        li.add(146   );
        li.add(147   );
        li.add(148   );
        li.add(149   );
        li.add(150   );
        li.add(153   );
        li.add(155   );
        li.add(157   );
        li.add(159   );
        li.add(161   );
        li.add(163   );
        li.add(164   );
        li.add(169   );
        li.add(170   );
        li.add(175   );
        li.add(176   );
        li.add(179   );
        li.add(180   );
        li.add(185   );
        li.add(187   );
        li.add(188   );
        li.add(189   );
        li.add(192   );
        li.add(196   );
        li.add(199   );
        li.add(201   );
        li.add(203   );
        li.add(205   );
        li.add(3     );
        li.add(7     );
        li.add(9     );
        li.add(10    );
        li.add(12    );
        li.add(13    );
        li.add(17    );

        new RotatedSortArray().findMinimumElement(li) ;
        int k = new RotatedSortArray().search(li,6);
    }
}
