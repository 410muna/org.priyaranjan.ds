package treeJava;

/**
 * Created by PSwain on 6/12/2017.
 */
public class preOrder {
    public void preOrder(Node node){

        if(node == null ){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);

    }

    public static void main(String[] args) {

        preOrder po =new preOrder();

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50);

        theTree.addNode(25);

        theTree.addNode(15);

        theTree.addNode(30);

        theTree.addNode(75);

        theTree.addNode(85);

        // Different ways to traverse binary trees

        // theTree.inOrderTraverseTree(theTree.root);

        // theTree.preorderTraverseTree(theTree.root);

        // theTree.postOrderTraverseTree(theTree.root);

        // Find the node with key 75

        po.preOrder(theTree.root);

    }
}
