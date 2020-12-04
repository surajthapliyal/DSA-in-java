package Queue;

import java.util.Scanner;

class MyQueue{
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    node front , rear;
    boolean isEmpty(){
        return front == null;
    }
    void enqueue(int data){
        node newNode = new node(data);
        if(isEmpty()){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        System.out.println(front.data + " is removed.");
        front = front.next;
        // if queue contains only one element and after removing
        // front will become null but the rear will still be pointing to that
        // element , so for that we have to make rear as null too . 

        // so after removing , if : 
        if(front == null){
            rear = null;
        }
    }
    void peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        System.out.println("Element at peek = " + front.data);
    }
    void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        node temp = front;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    void reverseDisplay(node head){
        if(head == null){
            return;
        }
        reverseDisplay(head.next);
        System.out.print(head.data+" ");
    }
    void reverseQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        // making rear point to front , so that we wont have to loop again
        // after reversing queueLL and update rear.
        rear = front;
        node curr = front;
        node prev = null;
        node nextAdd;
        while(curr != null){
            nextAdd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextAdd;
        }
        // now prev is pointing to the last node of queueLL.
        front = prev;
        display();
    }
}
public class usingLinkedList {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        Scanner sc = new Scanner(System.in);
        System.out.println("Queue operations are : ");
        int choice; 
        do{
            System.out.println("\n1.Enqueue.");
            System.out.println("2.Dequeue.");
            System.out.println("3.Peek.");
            System.out.println("4.IsEmpty?");
            System.out.println("5.Display.");
            System.out.println("6.Reverse Display.");
            System.out.println("7.Reverse whole queue.");
            System.out.println("8.Exit.\n");

            System.out.print("Enter your choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new data = ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    System.out.println(q.isEmpty());
                    break;
                case 5:
                    q.display();
                    break;
                case 6:
                    q.reverseDisplay(q.front);
                    break;
                case 7:
                    q.reverseQueue();
                    break;
                case 8:
                    System.out.println("Program Terminated.");
                    System.exit(1);
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }while(choice != 8);
        sc.close();
    }
}
