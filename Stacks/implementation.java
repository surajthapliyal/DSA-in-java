package Stacks;

import java.util.Scanner;

public class implementation {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print(("Enter size for the stack : "));
        int size = sc.nextInt();
        int stack[] = new int[size];
        int top = -1;
        int choice = 0;
        System.out.println("Stack operations : ");

        do{
            System.out.println("\n1.PUSH");
            System.out.println("2.POP");
            System.out.println("3.PEEK");
            System.out.println("4.DISPLAY");
            System.out.println("5.EXIT\n");

            System.out.print("Enter your Choice : ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: top = push(stack,size,top); break;
                case 2: top = pop(stack,top);  break;
                case 3: peek(stack,top); break;
                case 4: display(stack,top);  break;
                case 5:
                    System.out.println("Program Terminated !!");
                    System.exit(1);
                default:
                    System.out.println("Invalid !!,Please enter valid choice.");
                    break;
            }
        }while(choice!=5);
    }
    static int push(int stack[],int size,int top){
        if(top == size-1)
        {
            System.out.println("Stack Overflow!");
            return top;
        }
        System.out.print("Enter element to be pushed = ");
        int ele = sc.nextInt();
        stack[++top] = ele;
        return top;
    }
    static int pop(int stack[],int top){
        if(top == -1){
            System.out.println("Stack Underflow!!");
            return top;
        }
        System.out.println(stack[top--] +" element is pushed!");
        return top;
    }
    static void peek(int stack[],int top){
        if(top == -1){
            System.out.println("Stack Underflow!");
            return;
        }
        System.out.println("Element at the peek is = "+stack[top]);
    }
    static void display(int stack[],int top){
        if(top == -1){
            System.out.println("Stack Underflow!!");
            return;
        }
        for(int i=0;i<stack.length;i++){
            System.out.print(stack[i]+" ");
        }
    }
}
