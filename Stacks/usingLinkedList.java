package Stacks;

import java.util.Scanner;

class stackll{
    node head = null;
    node top = null;
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            next = null;
        }
    }
    void push(int data){
        node newNode = new node(data);
        if(top == null){
            head = newNode;
            top = newNode;
            return;
        }
        node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        top = newNode;
    }
    void pop(){
       if(top == null){
           System.out.println("Stack Empty!!");
           return;
       }
       node curr = head;
       node prev = null;
       while(curr.next != null){
            prev = curr;
            curr = curr.next;
       }
       System.out.println(curr.data + " is popped");
       prev.next = null;
       top = prev;
    }
    void peek(){
        if(top == null){
            System.out.println("List is Empty!!");
            return;
        }
        System.out.println("Peek = " + top.data);
    }
    int size(){
        if(top == null){
            System.out.println("List is Empty!!");
            return 0;
        }
        int i=0;
        node temp = head;
        while(temp != null){
            i++;
            temp = temp.next;
        }
        return i;
    }
    void display(){
        if(top == null){
            System.out.println("List is Empty!");
            return;
        }
        node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
public class usingLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stackll sl = new stackll();
        System.out.println("Stack operations are :");
        int choice = 0;
        do{
            System.out.println("\n1.PUSH");
            System.out.println("2.POP");
            System.out.println("3.PEEK");
            System.out.println("4.Display");
            System.out.println("5.Size");
            System.out.println("6.Exit\n");
            
            System.out.print("Enter choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sl.push(sc.nextInt());
                    break;
            
                case 2:
                    sl.pop();
                    break;
                case 3:
                    sl.peek();
                    break;
                case 4:
                    sl.display();
                    break;
                case 5:
                    System.out.println(sl.size());
                    break;
                case 6:
                    System.out.println("Program terminated!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }while(choice!=6);
        sc.close();
    }
}