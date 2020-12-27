package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Trees.BinaryTree.BinaryTree.node;

class BinaryTree{
    Scanner sc = new Scanner(System.in);
    class node {
        node left;
        node right;
        int data;

        node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    node root = null;
    
    node createTree(){
        System.out.print("Enter data = ");
        int data = sc.nextInt();
        // if dont want to create node below this:
        if(data == -1) return null;
        //otherwise create node :
        root = new node(data);

        // now doing the same for left node :
        System.out.println("Enter left for " + data + ":");
        root.left = createTree();

        // now doing the same for right node :
        System.out.println("Enter right for " + data + ":");
        root.right = createTree();

        return root;
    }

    void inOrder(node root){
        if(root == null) return;
        
        // left:
        inOrder(root.left);
        // data:
        System.out.print(root.data + " ");
        // right:
        inOrder(root.right);
    }

    void preOrder(node root){
        if(root == null) return;

        // data:
        System.out.print(root.data + " ");
        // left:
        preOrder(root.left);
        // right:
        preOrder(root.right);
    }

    void postOrder(node root){
        if(root == null) return;

        // left:
        postOrder(root.left);
        // right:
        postOrder(root.right);
        // data:
        System.out.print(root.data + " ");
    }

    void levelOrder(node root){
        if(root == null) return;
        Queue<node> q = new LinkedList<>();

        // firstly adding top root to the queue:
        q.add(root);

        // now loop till queue is not empty:
        while(!q.isEmpty()){
            // extract node from the queue :
            node extracted = q.remove();

            // print its data :
            System.out.print(extracted.data + " ");

            // add left child of extracted to the queue :
            if(extracted.left != null) q.add(extracted.left);
            
            // add right child of extracted to the queue :
            if(extracted.right != null) q.add(extracted.right);
        }
    }

    void insertByLevelOrder(node root , int newData){
        // we have to insert the newData at the first position which is empty while traversing
        // the tree in level order :
        if(root == null) return;

        Queue<node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            node extracted = q.remove();

            // for left child :
            if(extracted.left == null){
                extracted.left = new node(newData);
                System.out.println("Given new node is successfully added to tree!!");
                break;
            }else{
                q.add(extracted.left);
            }

            // for right child :
            if(extracted.right == null){
                extracted.right = new node(newData);
                System.out.println("Given new node is successfully added to tree!!");
                break;
            }else{
                q.add(extracted.right);
            }
        }
    }

    boolean containsNode(node root , int toCheck){
        if(root == null) return false;
        // if given root is the value to be checked :
        if(root.data == toCheck) return true;

        // recur on left subtree of the given root :
        if(containsNode(root.left, toCheck)){
            return true;
        }

        // if given data is not found on the left subtree then
        // recur on right subtree of the given root :
        return containsNode(root.right, toCheck);
    }

    node usingArray(int a[], node root, int i) {
        if (i < a.length) {
            // create new node to enter it in tree :
            node newNode = new node(a[i]);
            // assign root to it:
            root = newNode;

            // insert left child :
            root.left = usingArray(a, root.left, 2 * i + 1);

            // insert right child :
            root.right = usingArray(a, root.right, 2 * i + 2);
        }
        return root;
    }
}
public class implementation {
    public static void main(String[] args) {
 
        BinaryTree bt = new BinaryTree();
        System.out.println("Firstly Create a binary tree : ");
        node root = bt.createTree();

        System.out.println("\nBinary Tree operations include : ");

        int choice = 0;
        do{
            System.out.println("\n1.Display Inorder traversal.");
            System.out.println("2.Display Preorder traversal.");
            System.out.println("3.Display Postorder traversal.");
            System.out.println("4.Display Levelorder traversal.");
            System.out.println("5.Insert new node through levelOrder.");
            System.out.println("6.Contains node.");
            System.out.println("10.Exit.\n");
            
            System.out.print("Enter choice = ");
            choice = bt.sc.nextInt();
            
            switch (choice) {
                case 1:
                    bt.inOrder(root);
                    System.out.println();
                    break;
                case 2:
                    bt.preOrder(root);
                    System.out.println();
                    break;
                case 3:
                    bt.postOrder(root);
                    System.out.println();
                    break;
                case 4:
                    bt.levelOrder(root);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter new data to insert = ");
                    bt.insertByLevelOrder(root, bt.sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter node's data to search = ");
                    System.out.println(bt.containsNode(root, bt.sc.nextInt()));
                    break;
                case 10:
                    System.out.println("Program Terminated!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }while(choice!=10);
    }
}
