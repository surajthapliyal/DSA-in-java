package Trees.BinaryTree;

import java.util.Arrays;

class tree{
    int a[];
    int size;
    tree(int size){
        this.size = size;
        a = new int[size];
        Arrays.fill(a, -1);
    }

    void setRoot(int data){
        a[0] = data;
    }

    void setRootLeft(int data,int rootIndex){
        // calculate index for left side of root index :
        int i = 2*rootIndex+1;

        // if the given root is not in the tree :
        if(a[rootIndex]==-1){
            System.out.printf("Cant set given left value for rootIndex %d " , rootIndex);
        }else{
            a[i] = data;
        }
    }
    
    void setRootRight(int data, int rootIndex) {
        // calculate index for left side of root index :
        int i = 2 * rootIndex + 2;

        // if the given root is not in the tree :
        if (a[rootIndex] == -1) {
            System.out.printf("Cant set given right value for rootIndex %d ", rootIndex);
        } else {
            a[i] = data;
        }
    }

}
public class usingArray2 {
    public static void main(String[] args) {
        tree t = new tree(20);
        t.setRoot(1);
        t.setRootLeft(2, 0);
        t.setRootRight(3, 0);
        // t.setRootLeft(4, 1);
        t.setRootRight(5, 1);
        t.setRootLeft(6, 2);

        for(int i=0;i<t.size;i++){
            if(t.a[i] != -1){
                System.out.print(t.a[i] + " ");
            }else{
                System.out.print("-" + " ");
            }
        }
    }
}
