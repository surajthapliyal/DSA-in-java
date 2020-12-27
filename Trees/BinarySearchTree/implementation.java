package Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class binarySearchTree{
    class node{
        int data;
        node right;
        node left;
        node(int data){
            this.data = data;
            left = right = null;
        }
    }

    node root = null;

    void addRecursive(int newData){
        root = addRecursive(root, newData);
    }
    node addRecursive(node root,int newData){
        // if root is null then create a root :
        if(root==null) return new node(newData);

        if(newData < root.data)
            root.left = addRecursive(root.left, newData);
        else if(newData > root.data)
            root.right = addRecursive(root.right,newData);
        
        return root;
    }

    boolean isContains(int data){
        return isContains(root,data);
    }
    boolean isContains(node root , int data){
        if(root == null) return false;

        if(root.data == data) return true;

        return data < root.data?isContains(root.left, data):isContains(root.right, data);
    } 

    void displayLevelOrder(){
        levelOrder(root);
    }
    void levelOrder(node root) {
        if (root == null)
            return;
        Queue<node> q = new LinkedList<>();

        // firstly adding top root to the queue:
        q.add(root);

        // now loop till queue is not empty:
        while (!q.isEmpty()) {
            // extract node from the queue :
            node extracted = q.remove();

            // print its data :
            System.out.print(extracted.data + " ");

            // add left child of extracted to the queue :
            if (extracted.left != null)
                q.add(extracted.left);

            // add right child of extracted to the queue :
            if (extracted.right != null)
                q.add(extracted.right);
        }
    }

    void inOrder(){
        inOrder(root);
    }
    void inOrder(node root) {
        if (root == null) return;

        // left:
        inOrder(root.left);
        // data:
        System.out.print(root.data + " ");
        // right:
        inOrder(root.right);
    }

    int getMinValue(){
        return getMinValue(root);
    }
    int getMinValue(node root){
        // as all the nodes with min value are present on the left side of any 
        // subtree in the while tree so we only traverse in the left nodes :
        
        if(root==null){
            System.out.println("Tree is Empty!!");
            return -1;
        }
        // let root's data be the min firstly :
        int minValue = root.data;

        // loop till we reach the left leaf node 
        // as it is the one which is having the smallest value in the whole tree:
        while(root.left != null){
            minValue = root.left.data;
            root = root.left;
        }

        return minValue;
    }

    int getMaxValue(){
        return getMaxValue(root);
    }
    int getMaxValue(node root){
        if (root == null) {
            System.out.println("Tree is Empty!!");
            return -1;
        }
        int maxValue = root.data;
        while(root.right != null){
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }
    
    int getMaxValueRecursive() {
        return getMaxValueRecursive(root);
    }

    int getMaxValueRecursive(node root) {
        if (root == null) {
            System.out.println("Tree is Empty!!");
            return -1;
        }
        if(root.right == null){
            return root.data;
        }
        return getMaxValueRecursive(root.right);
    }

    int getMinValueRecursive() {
        return getMinValueRecursive(root);
    }

    int getMinValueRecursive(node root) {
        if (root == null) {
            System.out.println("Tree is Empty!!");
            return -1;
        }
        if (root.left == null) {
            return root.data;
        }
        return getMinValueRecursive(root.left);
    }

    int getHeight(){
        return getHeight(root);
    }
    int getHeight(node root){
        //time complexity  = O(N)

        // if root is null then the height will be -1 as the height of tree with only one node is 0:
        if(root==null) return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }


    void delete(int dataToDelete){
        root = delete(root, dataToDelete);
    }
    node delete(node root , int dataToDelete){
        if(root==null) return root;
        // if the data to be deleted is less than the root value
        // then we have to check in  the left side : 
        if(dataToDelete < root.data)
        root.left =  delete(root.left , dataToDelete);
        // if the data to be deleted is greater than the root value
        // then we have to check in the right side :
        else if(dataToDelete > root.data) 
        root.right = delete(root.right, dataToDelete);
        // if data to delete is equal to the root.data : (data found)
        else{
            // case 3:(if having both left and right child)
            if(root.left != null && root.right != null){
                // finding max form the left side and replacing the root's data with max 
                // and now deleting the node with max value(as it is duplicate now)
                int leftSideMax = max(root.left);
                root.data = leftSideMax;
                // this will go directly to the case 2(II) as the max node is surely on the right side:
                root.left = delete(root.left, leftSideMax);
                return root;
            }
            // case 2: I (if only left child)
            else if(root.left != null){
                // return left node as it is the only child:
                // and the link is to be created between parent and the grandchild
                return root.left;
            }
            // case 2: II (if only right child)
            else if(root.right != null){
                // return right node as it is the only child:
                // and the link is to be created between parent and the grandchild
                return root.right;
            }
            // case 3:(if leaf node)
            else{
                // returning null to the root (breaking link)
                return null;
            }
        }

        return root;
    }
    int max(node root){
        // we have to keep moving to the right child as the ma of the whole subtree is only 
        // present on the right leaf child:
        if(root.right != null) return max(root.right);
        else return root.data;
    }
}
class implementation{
    public static void main(String[] args){
        binarySearchTree bst = new binarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Binary Search tree operations include : ");
        int choice = 0;
        do{
            System.out.println("\n1.Add data.");
            System.out.println("2.Remove data.");
            System.out.println("3.Get Minimum value.");
            System.out.println("4.Print inorder");
            System.out.println("5.Is contains a given node.");
            System.out.println("6.Get maximum value.");
            System.out.println("7.Print level order.");
            System.out.println("8.Get Height of tree.");
            System.out.println("9.Delete a node.");
            System.out.println("10.Exit\n");

            System.out.print("Enter choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to enter : ");
                    bst.addRecursive(sc.nextInt());
                    break;
                case 3:
                    System.out.println(bst.getMinValueRecursive());
                    break;
                case 4:
                    bst.inOrder();
                    break;
                case 5:
                    System.out.print("Enter data to check : ");
                    System.out.println(bst.isContains(sc.nextInt()));
                    break;
                case 6:
                    System.out.println(bst.getMaxValueRecursive());
                    break;
                case 7:
                    bst.inOrder();
                    break;
                case 8:
                    System.out.println(bst.getHeight());
                    break;
                case 9:
                    System.out.print("Enter node data to delete : ");
                    bst.delete(sc.nextInt());
                    break;
                case 10:
                    System.out.println("Program terminated!!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }while(choice != 10);
        sc.close();
    } 
}