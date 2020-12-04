package LinkedList;
public class equalityOfTwoLists extends MyLinkedList{
    static boolean compareLists(node head1, node head2) {
        // if data in both list and the size of both list are equal then true:
        if (head1 == null && head2 == null)
            return true;
        if (head1 == null && head2 != null)
            return false;
        if (head1 != null && head2 == null)
            return false;
        // else check equality in both the lists :
        node temp1 = head1;
        node temp2 = head2;
        while (temp1 != null && temp2 != null && temp1.data == temp2.data) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == temp2;
    }
    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);

        l2.append(1);
        l2.append(2);
        l2.append(3);
        l2.append(4);

        if(equalityOfTwoLists.compareLists(l1.head, l2.head))
        System.out.println("Yes");
        else System.out.println("No");
    }
}
