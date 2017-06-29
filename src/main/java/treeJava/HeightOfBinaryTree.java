package treeJava;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by PSwain on 6/13/2017.
 */
public class HeightOfBinaryTree {
    public int getHeightOfTree(Node root){
        int height=0;
        java.util.Queue queue= new LinkedList<Node>();
        queue.add(root);
        queue.add((Node)null);

        while(! queue.isEmpty()){
            Node focusNode=(Node)queue.remove();
            if(focusNode == null){
                height ++;
                if(queue.isEmpty()){
                    break;
                }
                queue.add((Node)null);
            }else{

                if(focusNode.left != null){
                    queue.add(focusNode.left);
                }
                if(focusNode.right != null){
                    queue.add(focusNode.right);
                }
            }
        }
        return height -1 ;
    }


    public static void main(String[] args) {

        HeightOfBinaryTree ht =new HeightOfBinaryTree();

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50);

        theTree.addNode(25);

        //theTree.addNode(15);

        //theTree.addNode(30);

         theTree.addNode(75);

       // theTree.addNode(85);

        // Different ways to traverse binary trees

        // theTree.inOrderTraverseTree(theTree.root);

        // theTree.preorderTraverseTree(theTree.root);

        // theTree.postOrderTraverseTree(theTree.root);

        // Find the node with key 75

        int height= ht.getHeightOfTree(theTree.root);
        System.out.print("Hii");




        /*while(i.hasNext()){
            System.out.println(i.next());
        }*/
    }
}
