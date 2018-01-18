package treeJava;

public class inOrdeSucccsorAndPredessor {
    /*
    inorderPredessor is being derived
     */

    Node inorderPredessor(Node root){

        if(root ==  null){
            return null;
        }
        Node leftNode=root.left;
        Node focousNode=leftNode;
        Node parrentNode=focousNode;

        while(focousNode != null){
            parrentNode=focousNode;
            focousNode=focousNode.right;
        }
        return parrentNode;
    }

    Node inorderSuccessor(Node root){

        if(root == null){
            return null;
        }
        Node rightNode=root.right;
        Node focousNode=rightNode;
        Node parrentNode=rightNode;
        while(focousNode != null){
            parrentNode=focousNode;
            focousNode=focousNode.left;
        }
        return parrentNode;
    }

    Node searchNode(Node root,int data){

        Node focousNode=root;
        while(focousNode != null){

            if(focousNode.data == data){
                return focousNode;
            }
            else if(focousNode.data > data){
                focousNode=focousNode.left;
            }
            else{
                focousNode=focousNode.right;
            }
        }
        return null;
    }


    Node deleteNode(Node root,int data){

        //Search for the data in the tree
        Node focousNode=root;
        Node parrentNode=focousNode;
        Node searchedData=searchNode(focousNode,data);
        if(searchedData != null){
            focousNode=searchedData;
            System.out.println("Data found to be deleted");
        }else{
            System.out.println("Data not found to be deleted");
        }


        while(focousNode.right != null || focousNode.left != null){
            Node inOrdPre=inorderPredessor(focousNode);
            Node inOrdSuc=inorderSuccessor(focousNode);
            if(inOrdPre != null){
                focousNode.data=inOrdPre.data;
                focousNode=inOrdPre;
            }else if(inOrdSuc != null){
                focousNode.data=inOrdSuc.data;
                focousNode=inOrdSuc;
            }else{
                System.out.println("deleting leaf node :" + focousNode.data);
            }
        }
        return parrentNode;
    }


    public static void main(String [] args){
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.addNode(300);
        binaryTree.addNode(200);
        binaryTree.addNode(250);
        binaryTree.addNode(100);
        binaryTree.addNode(400);
        binaryTree.addNode(500);
        inOrdeSucccsorAndPredessor inOrder= new inOrdeSucccsorAndPredessor();

        Node inorderPre= inOrder.inorderPredessor(binaryTree.root);
        Node inorderSuc= inOrder.inorderSuccessor(binaryTree.root);

        System.out.println("inorderPre :" + inorderPre.data);
        if(inorderSuc == null){
            System.out.println("inorderSuc :" + "null");
        }
        System.out.println("inorderSuc :" + inorderSuc.data);
        //binaryTree.inOrderTraverseTree(binaryTree.root);
        Node searchedNode=inOrder.searchNode(binaryTree.root,400);
        System.out.println("Searched data : " + searchedNode.data);
        Node newTree= inOrder.deleteNode(binaryTree.root,200);
        System.out.println("Printing new root data :" + newTree.data);

    }

}
