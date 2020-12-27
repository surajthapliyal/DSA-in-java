package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class bTree{
    public class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
            left = right = null; 
        }
    }

    treeNode root = null;

    treeNode insertByLevelOrder(int a[] , treeNode root, int i){
        if(i<a.length){
            // create new treeNode to enter it in tree :
            treeNode newtreeNode = new treeNode(a[i]);
            // assign root to it:
            root = newtreeNode;

            // insert left child :
            root.left = insertByLevelOrder(a, root.left, 2*i+1);

            // insert right child :
            root.right = insertByLevelOrder(a, root.right, 2*i+2);
        }
        return root;
    }

    void levelOrder(treeNode root) {
        if (root == null)
            return;
        Queue<treeNode> q = new LinkedList<>();

        // firstly adding top root to the queue:
        q.add(root);

        // now loop till queue is not empty:
        while (!q.isEmpty()) {
            // extract treeNode from the queue :
            treeNode extracted = q.remove();

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
    
    void inOrder(treeNode root) {
        if (root == null)
            return;

        // left:
        inOrder(root.left);
        // data:
        System.out.print(root.data + " ");
        // right:
        inOrder(root.right);
    }

    void preOrder(treeNode root) {
        if (root == null)
            return;

        // data:
        System.out.print(root.data + " ");
        // left:
        preOrder(root.left);
        // right:
        preOrder(root.right);
    }

    void postOrder(treeNode root) {
        if (root == null)
            return;

        // left:
        postOrder(root.left);
        // right:
        postOrder(root.right);
        // data:
        System.out.print(root.data + " ");
    }
}
public class usingArray {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};

        bTree t = new bTree();

        //                   array   whereToInsert   index                     
        //                      |-----      |     ----|
        //                            |     |     |
        t.root = t.insertByLevelOrder(a, t.root, 0);
        t.inOrder(t.root);
        System.out.println();
        t.preOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
        System.out.println();
        t.levelOrder(t.root);
    }
}
