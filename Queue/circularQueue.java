package Queue;

import java.util.Scanner;

class Cqueue{
    private int size;
    private int front,rear;
    private int queue[];
    Cqueue(int size){
        this.size = size;
        queue = new int[size];
        front = rear = -1;
    }

    boolean isFull(){
        if(front == 0 && rear == size-1) return true;
        if(front == rear+1) return true;
        return false;
    }
    boolean isEmpty(){
        return front==-1;
    }
    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full!!");
            return;
        }
        // if list was empty:
        if(front == -1) front = rear = 0;
        else if(rear == size-1) rear = 0;
        else rear++;
        queue[rear] = data;
    }
    void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        System.out.println(queue[front] + " is removed.");
        if(front == rear) front = rear = -1;
        else if(front == size-1) front = 0;
        else front++;
    }
    void peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        System.out.println("At Peek = " + queue[front]);
    }
    void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        int i;
        for(i=front;i!=rear;i=(i+1)%size){
            System.out.print(queue[i] + " ");
        }
        // for last element : 
        System.out.println(queue[i]);
        System.out.println("\nFront index = " + front);
        System.out.println("Rear index = " + rear);  
    }
    void reverseDisplay(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        int i;
        for(i=rear;i!=front;i=(i-1)%size){
            System.out.print(queue[i]+" ");
        }
        // to display first:
        System.out.println(queue[i]);
    }
}
public class circularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size for the queue = ");
        Cqueue q = new Cqueue(sc.nextInt());
        System.out.println("Queue Operations are : ");
        int choice;
        do {
            System.out.println("\n1.Enqueue.");
            System.out.println("2.Dequeue.");
            System.out.println("3.Peek.");
            System.out.println("4.IsEmpty.");
            System.out.println("5.IsFull.");
            System.out.println("6.Display.");
            System.out.println("7.Display in reverse.");
            System.out.println("8.Exit.\n");

            System.out.print("Enter a choice = ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data to Enqueue : ");
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
                    System.out.println(q.isFull());
                    break;
                case 6:
                    q.display();
                    break;
                case 7:
                    q.reverseDisplay();
                    break;
                case 8:
                    System.out.println("Program terminated!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid Choice!!!");
                    break;
            }
        } while (choice != 9);
        sc.close();
    }
}
