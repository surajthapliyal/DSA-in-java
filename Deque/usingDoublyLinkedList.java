package Deque;

import java.util.Scanner;

class Dlldeque{
    class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data = data;
        }
    }
    node head = null;
    node tail = null;

    boolean isEmpty(){
        return head==null;
    }
    void insertFront(int data){
        node newNode = new node(data);
        if(isEmpty()){  
            head = tail = newNode;
            return;
        }
        // else insert normally at front : 
        newNode.next = head;
        head.prev = newNode;
        // make newNode head;
        head = newNode;
    }
    void insertLast(int data){
        node newNode = new node(data);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        // else insert it at last :
        tail.next = newNode;
        newNode.prev = tail;
        // point tail to last : 
        tail = newNode;
    }
    void removeFirst(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        System.out.println(head.data + " is removed.");
        // if list contain only one element :
        if(head.next == null) {
            head = tail = null;
            return;
        }
        head.next.prev = null;
        head = head.next;
    }
    void removeLast(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        System.out.println(tail.data + " is removed.");
        // if list contain only one element :
        if(head.next==null){
            head = tail = null;
            return;
        }
        tail.prev.next = null;
        tail = tail.prev;
    }
    int getFront(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return -1;
        }
        return head.data;
    }
    int getLast(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return -1;
        }
        return tail.data;
    }
    void display(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    void displayReverse(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        node temp = tail;
        while(temp != null){
            System.out.print(temp.data + "<-");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
    int size(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return 0;
        }
        node temp = head;
        int i=0;
        while(temp != null){
            i++;    
            temp = temp.next;
        }
        return i;
    }
}
public class usingDoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dlldeque dq = new Dlldeque();
        System.out.println("Deque operations are : ");
        int choice;
        do {
            System.out.println("\n1.Insert at front.");
            System.out.println("2.Insert at rear.");
            System.out.println("3.Remove from front.");
            System.out.println("4.Remove from rear.");
            System.out.println("5.Peek from front.");
            System.out.println("6.Peek from rear.");
            System.out.println("7.Display.");
            System.out.println("8.Display reverse.");
            System.out.println("9.Size.");
            System.out.println("10.Exit.\n");

            System.out.print("Enter your choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new data = ");
                    dq.insertFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter new data = ");
                    dq.insertLast(sc.nextInt());
                    break;
                case 3:
                    dq.removeFirst();
                    break;
                case 4:
                    dq.removeLast();
                    break;
                case 5:
                    System.out.println("Front peek = " + dq.getFront());
                    break;
                case 6:
                    System.out.println("Rear peek = " + dq.getLast());
                    break;
                case 7:
                    dq.display();
                    break;
                case 8:
                    dq.displayReverse();
                    break;
                case 9:
                    System.out.println("Size = " + dq.size());
                    break;
                case 10:
                    System.out.println("Program Terminated.");
                    System.exit(1);
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        } while (choice != 10);
        sc.close();
    }
}
