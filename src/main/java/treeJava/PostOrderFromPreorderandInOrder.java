package treeJava;

import java.util.LinkedList;
import java.util.Queue;

public class PostOrderFromPreorderandInOrder {
     void postOrder(LinkedList preorder,LinkedList inorder){
         if(preorder == null || inorder == null){
             return;
         }


         if(inorder.size() == 0){
             return;
         }

         Queue q = preorder;
         int rootdata= (Integer)preorder.removeFirst();
         int index=inorder.indexOf(rootdata);



         LinkedList leftTree= new LinkedList(inorder.subList(0,index));
         LinkedList rightTree = new LinkedList(inorder.subList(index+1,inorder.size()));
         postOrder(preorder,leftTree);
         postOrder(preorder,rightTree);

         System.out.print(rootdata + " ");

     }

     public static void main(String[] args){
         LinkedList inOder = new LinkedList<Integer>();
         inOder.add(4);
         inOder.add(2);
         inOder.add(5);
         inOder.add(1);
         inOder.add(3);
         inOder.add(6);

         LinkedList preOder = new LinkedList<Integer>();
         preOder.add(1);
         preOder.add(2);
         preOder.add(4);
         preOder.add(5);
         preOder.add(3);
         preOder.add(6);
         new PostOrderFromPreorderandInOrder().postOrder(preOder,inOder);
     }




}
