package treeJava;


/**
 * Created by PSwain on 6/12/2017.
 */

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {

        this.data = data;
    }
    public String toString() {

        return data + " has the data ";

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

    }
}


public class BinaryTree {

    Node root;
    

        public void addNode(int data) {

        // Create a new Node and initialize it

        Node newNode = new Node(data);

        // If there is no root this becomes root

        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree

            Node focusNode = root;

            // Future parent for our new Node

            Node parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node

                if (data < focusNode.data) {

                    // Switch focus to the left child

                    focusNode = focusNode.left;

                    // If the left child has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.left = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.right;

                    // If the right child has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.right = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node

            inOrderTraverseTree(focusNode.left);

            // Visit the currently focused on node

            System.out.println(focusNode);

            // Traverse the right node

            inOrderTraverseTree(focusNode.right);

        }

    }

    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.left);
            preorderTraverseTree(focusNode.right);

        }

    }

    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);

            System.out.println(focusNode);

        }

    }

    public Node findNode(int key) {

        // Start at the top of the tree

        Node focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.data != key) {

            // If we should search to the left

            if (key < focusNode.data) {

                // Shift the focus Node to the left child

                focusNode = focusNode.left;

            } else {

                // Shift the focus Node to the right child

                focusNode = focusNode.right;

            }

            // The node wasn't found

            if (focusNode == null)
                return null;

        }

        return focusNode;

    }

    public static void main(String[] args) {

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

        System.out.println("\nNode with the key 75");

        System.out.println(theTree.findNode(75));

    }





}
