package CircularLinkedList;

import LinkedList.MyLinkedList;
class circular extends MyLinkedList{
    void makeCircular(){
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        node temp = head;
        // traverse till last and change last node link to point head : 
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        System.out.println("Converted");
    }
}
public class singlyToCircular {
    public static void main(String[] args) {
        // making object of singly linkedList we implemented : 
        circular ll = new circular();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.display();
        ll.makeCircular();
    }
}
