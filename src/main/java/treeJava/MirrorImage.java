package treeJava;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorImage {

    void mirror(Node node) {
        if(node == null){
            return;
        }
        Queue queue = new LinkedList();
        queue.add(node);
        Node tempNode;
        while(! queue.isEmpty()){
            Node focusNode=(Node)queue.remove();
            if(focusNode.left != null || focusNode.right != null){
                tempNode=focusNode.right;
                focusNode.right=focusNode.left;
                focusNode.left=tempNode;
            }
            if(focusNode.left != null ){
                queue.add(focusNode.left);
            }
            if(focusNode.right != null){
                queue.add(focusNode.right);
            }
        }
    }

    public static void main(String [] args){
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.addNode(300);
        binaryTree.addNode(200);
        binaryTree.addNode(250);
        binaryTree.addNode(100);
        binaryTree.addNode(400);
        binaryTree.inOrderTraverseTree(binaryTree.root);

        MirrorImage mi = new MirrorImage();
        mi.mirror(binaryTree.root);
        binaryTree.inOrderTraverseTree(binaryTree.root);
    }
}

