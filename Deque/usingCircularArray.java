package Deque;

import java.util.Scanner;

class Cdeque{
    private int size;
    private int front,rear;
    private int deque[];
    Cdeque(int size){
        this.size = size;
        deque = new int[size];
        front = rear = -1;
    }
    boolean isEmpty(){
        return front==-1;
    }
    boolean isFull(){
        if(front==0 && rear == size-1) return true;
        if(front == rear+1) return true;
        return false;
    }
    void insertFront(int data){
        if(isFull()){
            System.out.println("Deque is Full!!");
            return;
        }
        // if deque is initially empty: 
        if(front == -1){
            front = rear = 0;
        }
        // if front was in the start of deque , for that we have to
        // move it to the last of queue because it is a circular :
        else if(front == 0) front = size-1;
        // else shift normally (one step previous) : 
        else front--;

        // now insert element at front : 
        deque[front] = data;
    }
    void insertRear(int data){
        if(isFull()){
            System.out.println("Deque is Full!!");
            return;
        }
        // if deque is initially empty : 
        if(front == -1) front = rear = 0;
        // if rear is at last then move it to the first place because
        // it is a circular array : 
        else if(rear == size-1) rear = 0;
        // else update it normally :
        else rear++;
        deque[rear] = data; 
    }
    void removeFront(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        System.out.println(deque[front] + " is removed.");
        // if deque has only one element :
        if(front == rear) front = rear = -1;
        // if front is at last then move it back to the front
        //  as it is a circular array : 
        else if(front == size-1) front = 0;
        // else update front normally : 
        else front++;
    }
    void removeRear(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        System.out.println(deque[rear] + " is removed.");
        // if deque has only one element :
        if(front == rear) front = rear = -1;
        // if rear is in front then move it to last as it is a 
        // circular array : 
        else if(rear == 0) rear = size-1;
        // else update rear normally : 
        else rear--;
    }
    int getFront(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return -1;
        }
        return deque[front];
    }
    int getRear(){
        if(isEmpty() || rear < 0){
            System.out.println("Deque is Empty!!");
            return -1;
        }
        return deque[rear];
    }
    void display(){
        if(isEmpty()){
            System.out.println("Deque is Empty!!");
            return;
        }
        int i;
        for(i=front ; i!=rear ; i=(i+1)%size){
            System.out.print(deque[i] + " ");
        }
        System.out.println(deque[i]);
    }
}
public class usingCircularArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size = ");
        Cdeque cd = new Cdeque(sc.nextInt());
        System.out.println("ArrayDeque Operations are : ");
        int choice;
        do{
            System.out.println("\n1.Insert at front.");
            System.out.println("2.Insert at rear.");
            System.out.println("3.Remove from front.");
            System.out.println("4.Remove from rear.");
            System.out.println("5.Peek from front.");
            System.out.println("6.Peek from rear.");
            System.out.println("7.Display.");
            System.out.println("8.Exit.\n");

            System.out.print("Enter your choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new data = ");
                    cd.insertFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter new data = ");
                    cd.insertRear(sc.nextInt());
                    break;
                case 3:
                    cd.removeFront();
                    break;
                case 4:
                    cd.removeRear();
                    break;
                case 5:
                    System.out.println("Front peek = " + cd.getFront());
                    break;
                case 6:
                    System.out.println("Rear peek = " + cd.getRear());
                    break;
                case 7:
                    cd.display();
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
