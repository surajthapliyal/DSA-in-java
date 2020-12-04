package DoublyLinkedList;

import java.util.Scanner;

class DLL{
    node head = null;
    class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data = data;
            // prev and next will automatically gets initialized as null.
        }
    }
    void insertAtFront(int data){
        node newNode = new node(data);
        // if list is empty : 
        if(head == null){
            head = newNode;
            return;
        }
        // else insert it at beginning by building both next and prev link:
        newNode.next = head;
        head.prev = newNode;
        head = newNode;        
    }
    void append(int data){
        node newNode = new node(data);
        // if list is empty :
        if(head == null){
            head = newNode;
            return;
        }
        // else traverse till last node and link newNode to last : 
        node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }
    void forwardPrint(){
        // if list is empty:
        if(head == null){
            System.out.println("List is Empty!!");
            return;
        }
        node traverse = head;
        while(traverse != null){
            System.out.print(traverse.data + "->");
            traverse = traverse.next;
        }
        System.out.println("NULL");
    }
    void reversePrint(){
        // if list is empty:
        if(head == null){
            System.out.println("List is Empty!!");
            return;
        }
        node traverse = head;
        // pointing traverse pointer to last node :
        while(traverse.next != null){
            traverse = traverse.next;
        }
        // now print data backwards :
        while(traverse != null){    //as first node's prev is null
            System.out.print(traverse.data+"<-");
            traverse = traverse.prev;
        }
        System.out.println("NULL");
    }
    void insertAfter_A_node(node given,int newData){
        if(given == null){
            System.out.println("Given node cannot be null");
            return;
        }
        // create node :
        node newNode = new node(newData);
        // adjusting RHS links first so that we wont loose that value.
        newNode.next = given.next;
        // if given was last node then given.next will be null
        // so it will make newNode last automatically by storing 
        // null to newNode.next, but if it wasn't : 
        if(given.next != null){
            // then we will store newNode's next node's prev link as
            // newNode's address to create prev link on RHS.
            newNode.next.prev = newNode;
        }

        // now adjust LHS links :
        newNode.prev = given;
        given.next = newNode;
    }
    void insertBefore_A_node(node given,int newData){
        if(given == null){
            System.out.println("Given node cannot be null.");
            return;
        }
        // create node :
        node newNode = new node(newData);
        // adjusting LHS links first so that we wont loose that value.
        newNode.prev = given.prev;
        // if given was first node then given.prev will be null
        // so it will make newNode first automatically by storing
        // null to newNode.prev, but if it wasn't :
        if(given.prev!=null){
            // then we will store newNode's prev node's next link as
            // newNode's address to create prev link on LHS.
            newNode.prev.next = newNode;
        }
        // now adjust LHS links :
        newNode.next = given.prev;
        given.prev = newNode;
    }
    void insertAt_a_givenIndex(int index,int newData){
        if(head == null){
            System.out.println("List is Empty!!");
            return;
        }
        // if invalid index : 
        if(index < 0){
            System.out.println("Invalid index");
            return;
        }
        node newNode = new node(newData);
        // if first element :
        if(index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } 
        // else traverse through list and find index : 
        int i = 0;
        node temp = head;
        while(temp.next != null){
            temp = temp.next;
            i++;
            if(i == index-1){
                newNode.next = temp.next;
                if(temp.next != null){
                    newNode.next.prev = newNode;    
                }
                newNode.prev = temp;
                temp.next = newNode;
                return;
            }
        }
        if(i != index){
            System.out.println("No Such Index!!");
        }
    }
    int size(){
        if(head == null){
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
    void removeLast(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        node temp = head;
        // if list contain only one element : 
        if(head.next == null){
            head = null;
            return;
        }
        // else, if list contain more than one element : 
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = null;
    }
    void removeFirst(){
        if(head == null){
            System.out.println("List is Empty!!");
            return;
        }
        // if list contains only one element : 
        if(head.next == null){
            head = null;
        }
        // else, if list contain more than one element :
        head.next.prev = null;
        head = head.next;
    }
    void removeAt(int index){
        if(head == null){
            System.out.println("List is Empty!!");
            return;
        }
        if(index  < 0){
            System.out.println("Invalid Index!!");
            return;
        }
        if(index  == 0){
            if (head.next == null) {
                head = null;
                return;
            }
            else{
                head.next.prev = null;
                head = head.next;
                return;
            }
        }
        int i=0;
        node temp = head;
        while(temp.next != null){
            temp = temp.next;
            i++;
            if(i == index-1){
                temp.next = temp.next.next.prev;
                temp.next.next.prev = temp;
                return;
            }
        }
        if(index != i){
            System.out.println("No Such Index!");
        }
    }
    void removeNode(node del){
        // if node to delete is null or list is empty :  
        if(head == null || del == null){
            return;
        }
        // if head node to delete : 
        if(head == del){
            head = head.next;
            return;
        }
        // if node is in the mid :
        if(del.next != null){
            del.next.prev = del.prev;
            del.prev.next = del.next;
            return;
        }
    }
}
public class usingClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL dll = new DLL();
        System.out.println("Double Linked List operations are : ");
        int choice;
        do{
            System.out.println("\n1.Add at front.");
            System.out.println("2.Append.");
            System.out.println("3.Forward print.");
            System.out.println("4.Backward print.");
            System.out.println("5.Insert at a given index.");
            System.out.println("6.Size.");
            System.out.println("7.Remove last.");
            System.out.println("8.Remove first.");
            System.out.println("9.Remove at a given index.");
            System.out.println("10.EXIT.\n");
            
            System.out.print("Enter your choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert = ");
                    dll.insertAtFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter data to append = ");
                    dll.append(sc.nextInt());
                    break;
                case 3:
                    dll.forwardPrint();
                    break;
                case 4:
                    dll.reversePrint();
                    break;
                case 5:
                    System.out.print("Enter index = ");
                    int index = sc.nextInt();
                    System.out.print("Enter new data = ");
                    int newData = sc.nextInt();
                    dll.insertAt_a_givenIndex(index, newData);
                    break;
                case 6:
                    System.out.println("Size of the list = " + dll.size());
                    break;
                case 7:
                    dll.removeLast();
                    break;
                case 8:
                    dll.removeFirst();
                    break;
                case 9:
                    System.out.print("Enter index = ");
                    int Rindex = sc.nextInt();
                    dll.removeAt(Rindex);
                    break;
                case 10:
                    System.out.println("Program terminated.");
                    System.exit(1);
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
        }while(choice != 10);
        sc.close();
    }
}
