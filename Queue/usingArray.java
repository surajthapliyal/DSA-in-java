package Queue;

import java.util.Scanner;

class Queue{
    private int size , front , rear;
    private int queue[];
    Queue(int size){
        this.size = size;
        queue = new int[size];
        front = rear = -1;
    }
    boolean isFull(){
        return (front == 0 && rear == size-1);
    }
    boolean isEmpty(){
        return (front==-1);
    }
    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full!");
            return;
        }
        // if queue is Empty : 
        if(front==-1) front=0;
        // else increment rear and then add data to it : 
        queue[++rear] = data;
    }
    void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        // if queue contains only one element or incase front is 
        // pointing forward of rear which is invalid then :
        if(front >= rear){
            System.out.println(queue[front] + " is removed");
            front = rear = -1;
            return;
        }
        System.out.println(queue[front]+" is removed");
        front++;
    }
    void peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        System.out.println("Item at peek = " + queue[front]);
    }
    void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        for(int i = front; i<=rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println("\nFront Index = " + front);
        System.out.println("Rear Index = " + rear);
    }
    void displayReverse(){
        if (isEmpty()) {
            System.out.println("Queue is Empty!!");
            return;
        }
        for(int i = rear ; i>=front ; i--){
            System.out.print(queue[i] + " ");
        }
    }
    void reverseQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
            return;
        }
        int start = front , end = rear;
        while(start < end){
            int temp = queue[start];
            queue[start] = queue[end];
            queue[end] = temp;
            start++; end--;
        }
    }
}
public class usingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size for the queue = ");
        Queue q = new Queue(sc.nextInt());
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
            System.out.println("8.Reverse Queue.");
            System.out.println("9.Exit.\n");

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
                    q.displayReverse();
                    break;
                case 8:
                    q.reverseQueue();
                    q.display();
                    break;
                case 9:
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
