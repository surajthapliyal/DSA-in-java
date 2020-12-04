package Stacks;

import java.util.Scanner;

class createStack{
    private int size;
    private int top;
    private int stack[];

    createStack(int length){
        size = length;
        stack = new int[length];
        top = -1;
    }
    boolean isEmpty(){
        return(top < 0);
    }
    boolean isFull(){
        return (top>=size-1);
    }
    void push(int item){
        if(isFull()){
            System.out.print("Stack Overflow!");
            return;
        }
        stack[++top] = item;
    }
    void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow!");
            return;
        }
        System.out.println(stack[top--]+" is popped from the stack.");
    }
    void peek(){
        if(isEmpty()){
            System.out.print("Stack Underflow!");
            return;
        }
        System.out.println("Item at peek = "+stack[top]);
    }
    void display(){
        if(isEmpty()){
            System.out.println("Stack Underflow!");
            return;
        }
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]+" ");
        }
    }
}
public class usingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size for the stack = ");
        int size = sc.nextInt();
        createStack stack1 = new createStack(size); 
        System.out.println("Stack operations are : ");
        int choice;
        do{
            System.out.println("\n1.PUSH");
            System.out.println("2.POP");
            System.out.println("3.PEEK");
            System.out.println("4.DISPLAY");
            System.out.println("5.EXIT\n");

            System.out.print("Enter choice = ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to push = ");
                    int ele = sc.nextInt();
                    stack1.push(ele);
                    break;
                case 2:
                    stack1.pop();
                    break;
                case 3:
                    stack1.peek();
                    break;
                case 4:
                    stack1.display();
                    break;
                case 5:
                    System.out.println("Program Terminated!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid!! Please enter valid choice!!");
                    break;
            }
        }while(choice!=5);
        sc.close();
    }
}
