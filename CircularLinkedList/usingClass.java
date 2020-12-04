package CircularLinkedList;

import java.util.Scanner;

class CLL{
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    node last = null;
    void addToEmpty(int data){
        if(last != null){
            System.out.println("List is not empty.");
            return;
        }
        // else,create new node :
        node newNode = new node(data);
        // point last to this node as it is the one and only node in the list.
        last = newNode;
        // now make it a circular : 
        last.next = last;
    }
    void addAtFront(int data){
        if(last == null){
            addToEmpty(data);
            return;
        }
        // else,create a new node : 
        node newNode = new node(data);
        //now make it last node :
        // to make it last node we have to store first node's address
        // in the newNode.next(as it is a CLL)
        newNode.next = last.next;
        last.next = newNode;
    }
    void append(int data){
        if(last == null){
            addToEmpty(data);
            return;
        }
        node newNode = new node(data);
        newNode.next = last.next;
        last.next = newNode;
        // now make last point to newNode : 
        last = newNode;
    }
    void addAfterData(int givenData,int newData){
        if(last == null){
            System.out.println("List is EMpty!!");
            return;
        }
        node newNode = new node(newData);
        node temp = last.next;
        // loop through list once
        // start from head(last.next) till temp!=last.next(which is again)
        do{
            if(temp.data == givenData){
                newNode.next = temp.next;
                temp.next = newNode;
                // if temp was the last element : 
                if(temp == last)
                    last = newNode;
                return;
            }
            temp = temp.next;
        }while(temp != last.next);
        // if givenData not found in the list : 
        System.out.println("Data not Found in the whole list.");
    }
    void addAt(int index,int newData){
        if(last == null){
            System.out.println("List is Empty!!");
            return;
        }
        if(index < 0){
            System.out.println("Invalid Index!!");
            return;
        }
        node newNode = new node(newData);
        node temp = last.next;
        if(index == 0){
            last.next = newNode;
            newNode.next = temp;
            return;
        }
        int i=0;
        do{
            if(i == index-1){
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            i++;
            temp = temp.next;
        }while(temp != last.next);
        System.out.println("Index Not found!");
    }
    void removeFirst(){
        if(last == null){
            System.out.println("List is Empty!!");
            return;
        }
        // if it is the only node
        if(last.next == last){
            last = null;
            return;
        }
        // else,
        last.next = last.next.next;
    }
    void removeLast(){
        if(last == null){
            System.out.println("List is Empty!!");
            return;
        }
        if(last.next == last){
            last = null;
            return;
        }
        node temp = last.next;
        while(temp.next != last){
            temp = temp.next;
        }
        temp.next = last.next;
        last = temp;
    }
    void removeData(int toRemove){
        if(last == null){
            System.out.println("List is Empty!");
            return;
        }
        // if first element : 
        if(last.next.data == toRemove){
            last.next = last.next.next;
            // if it is the only element in the list : 
            if(last.next == last) last = null;
            return;
        }
        node curr = last.next;
        node prev = null;
        do{
            if(curr.data == toRemove){
                prev.next = curr.next;
                if(curr == last)
                    last = prev;
                return;
            }
            prev = curr;
            curr = curr.next;
        }while(curr != last.next);
        System.out.println("Data not found in the list.");
    }
    void removeAt(int index){
        if(last == null){
            System.out.println("List is Empty!!");
            return;
        }
        if(index < 0){
            System.out.println("Invalid Index!!");
            return;
        }
        if(index == 0){
            if(last.next==last){
                last = null;
                return;
            }if(last.next != last){
                last.next = last.next.next;
                return;
            }
        }
        int i=0;
        node curr = last.next;
        node prev = null;
        do{
            if(i == index){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }while(curr != last.next);
        if(i!=index) System.out.println("Index not Found");
    }
    void display(node head){
        if(head == null){
            System.out.println("List is Empty!!");
            return;
        }
        // create pointer for the head node : 
        node temp = head;
        // loop through the list once and print data :
        do{
            System.out.print(temp.data + "->");
            temp = temp.next;
        }while(temp != head);
        System.out.println("repeat.");
    }
    void reversePrint(node head){
        if(last == null){
            System.out.println("List is Empty!");
            return;
        }
        if(head.next == last.next) {
            //we have to write last node data self
            // because otherwise it wont get print.
            System.out.print(head.data+" ");    
            return;
        }
        reversePrint(head.next);
        System.out.print(head.data+" ");
    }
    void reverseCLL(){
        if(last == null){
            System.out.println("List is Empty!!");
            return;
        }
        node head = last.next;
        node curr = head; //(head)
        node prev = null;
        node nextAdd;
        do{
            nextAdd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextAdd; 
        }while(curr != head);

        // now prev is pointing to last node :
        // now making head to point last node(prev) :
        head.next = prev;
        // last node will be head as list is reversed,
        last = head;
        display(last.next);
    }
    int size(){
        if(last == null) return 0;
        int i=0;
        node temp = last.next;
        do{
            i++;
            temp = temp.next;
        }while(temp != last.next);
        return i;
    }
    void split(){
        int mid;
        // as size will return 1basedIndexed size : 
        // if size is odd then first half will have one more node
        if(size()%2!=0) mid = size()/2;
        // if even, split normally : 
        else mid = (size()/2)-1;
        // if list contain only one node then splitting cannot be done.
        if(size() == 1){
            System.out.println("Single node list cannot be split.");
            return;
        }
        // create temp to traverse : 
        node temp = last.next;
        // create temp2 as a head pointer for second half.
        node temp2;
        // if i matches mid then split : 
        int i=0;
        do{
            if(mid == i){
                // firstly assign temp2 so that we will not loose that value.
                temp2 = temp.next;
                // make first half :  
                temp.next = last.next;
                // make second half : 
                last.next = temp2;
                System.out.print("Part1 : ");
                // passing first half head to display : 
                display(temp.next);
                System.out.print("Part2 : ");
                // passing second half head to display :
                display(temp2);
                return;
            }
            // else traverse forward : 
            temp = temp.next;
            i++;
        }while(temp != last.next);
    }
}
public class usingClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLL cll = new CLL();
        System.out.println("Circular Linked List Operations are : ");
        int choice ; 
        do{
            System.out.println("\n1.Add to Empty List.");
            System.out.println("2.Add at beginning of the CLL.");
            System.out.println("3.Append.");
            System.out.println("4.Insert after a specified node.");
            System.out.println("5.Insert at a specified index.");
            System.out.println("6.Remove first node.");
            System.out.println("7.Remove last node.");
            System.out.println("8.Remove specified node.");
            System.out.println("9.Remove specified index.");
            System.out.println("10.Display.");
            System.out.println("11.Display size of the list,");
            System.out.println("12.Reverse Print using recursion.");
            System.out.println("13.Reverse CLL.");
            System.out.println("14.Split list into two halves.");
            System.out.println("15.Exit\n");

            System.out.print("Enter your choice = ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data to enter in the empty list = ");
                    cll.addToEmpty(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter data to insert = ");
                    cll.addAtFront(sc.nextInt());
                    break;
                case 3: 
                    System.out.print("Enter data to append = ");
                    cll.append(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter where to insert = ");
                    int givenData = sc.nextInt();
                    System.out.print("Enter what to insert = ");
                    int newData = sc.nextInt();
                    cll.addAfterData(givenData, newData);
                    break;
                case 5:
                    System.out.print("Enter index = ");
                    int i= sc.nextInt();
                    System.out.print("Enter new data = ");
                    int d = sc.nextInt();
                    cll.addAt(i, d);
                    break;
                case 6:
                    cll.removeFirst();
                    break;
                case 7:
                    cll.removeLast();
                    break;
                case 8:
                    System.out.print("Enter data to remove = ");
                    cll.removeData(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Enter index to remove = ");
                    cll.removeAt(sc.nextInt());
                    break;
                case 10:
                    cll.display(cll.last.next);
                    break;
                case 11:
                    System.out.println("Size = " + cll.size());
                    break;
                case 12:
                    cll.reversePrint(cll.last.next);
                    break;
                case 13:
                    cll.reverseCLL();
                    break;
                case 14:
                    cll.split();
                    break;
                case 15:
                    System.out.println("Program Terminated!!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid choice ! Please enter valid choice.");
                    break;
            }
        }while(choice != 15);
        sc.close();
    }
}
