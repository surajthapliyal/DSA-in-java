package Trees.ThreadedBinaryTree;

public class DoubleThreadedBinaryTree {

    public static Node dummy;
    public static boolean directionLeft;
    public static boolean directionRight;

    public DoubleThreadedBinaryTree() {
        // create the dummy node
        dummy = new Node(Integer.MAX_VALUE);
        dummy.leftBit = 0;
        dummy.rightBit = 1;
        dummy.left = dummy.right = dummy;
    }

    public void insert(int data) {
        Node n = new Node(data);
        // check if new node is going to be first actual node in the tree.
        if (dummy == dummy.left && dummy.right == dummy) {
            
            n.left = dummy;
            n.right = dummy;
            
            dummy.left = n;
            n.leftBit = dummy.leftBit;
            dummy.leftBit = 1;
        } else {
            Node current = dummy.left;
            while (true) {
                if (current.data > n.data) {
                    if (current.leftBit == 0) {
                        // node will be added as left child
                        directionLeft = true;
                        directionRight = false;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.rightBit == 0) {
                        // node will be added as right child
                        directionLeft = false;
                        directionRight = true;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
            if (directionLeft) {
                // add the node as left child
                n.left = current.left;
                current.left = n;
                n.leftBit = current.leftBit;
                current.leftBit = 1;
                n.right = current;
            } else if (directionRight) {
                // add the node as right child
                n.right = current.right;
                current.right = n;
                n.rightBit = current.rightBit;
                current.rightBit = 1;
                n.left = current;
            }
        }
    }

    public void inorder() {
        // start from the left child of the dummy node
        Node current = dummy.left;
        // go to the left most node
        while (current.leftBit == 1) {
            current = current.left;
        }
        // now keep traversing the next inorder successor and print it
        while (current != dummy) {
            System.out.print("  " + current.data);
            current = findNextInorder(current);
        }
    }

    public Node findNextInorder(Node current) {
        // if rightBit of current node is 0 means current node does not
        // have right child so use the right pointer to move to its
        // inorder successor.
        if (current.rightBit == 0) {
            return current.right;
        }
        // if //if rightBit of current node is 0 means current node does
        // have right child so go to the left most node in right sub tree.
        current = current.right;
        while (current.leftBit != 0) {
            current = current.left;
        }
        return current;
    }

    public static void main(String args[]) {
        DoubleThreadedBinaryTree i = new DoubleThreadedBinaryTree();
        i.insert(10);
        i.insert(12);
        i.insert(15);
        i.insert(2);
        i.insert(13);
        i.insert(1);
        i.insert(4);
        i.inorder();
    }
}

class Node {
    int data;
    int leftBit;
    int rightBit;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}