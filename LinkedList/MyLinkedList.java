package LinkedList;
// created all method public so that SinglyToCircular in CircularLinkedList package can use them.
public class MyLinkedList {
        // creating node class
        public class node {
            public int data;
            public node next;

            node(int data) {
                this.data = data;
                next = null;
            }
        }

        public node head = null;

        public void append(int data) {
            node newNode = new node(data);
            // if list is empty
            if (head == null) {
                head = newNode;
                return;
            } else {
                node temp = head;
                // traverse till last
                while (temp.next != null) {
                    temp = temp.next;
                }
                // adjust last node
                temp.next = newNode;
            }
        }

        public void addAt(int index, int data) {
            // if list is empty
            if (head == null) {
                System.out.println("List is Empty!!");
                return;
            }
            node newNode = new node(data);
            // if invalid index
            if (index < 0) {
                System.out.println("Invalid index!");
                return;
            }
            // if first node
            if (index == 0) {
                newNode.next = head;
                head = newNode;
                return;
            }
            // else, traverse till index-1th element
            int i = 0;
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                i++;
                if (i == index - 1) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                }
            }
        }

        public void remove(int data) {
            node curr = head;
            node prev = null;
            // if list is empty
            if (head == null) {
                System.out.println("List is empty!");
                return;
            }
            // if first node is the data to be removed
            if (head.data == data) {
                // if list has more elements
                if (head.next != null) {
                    head = curr.next;
                    return;
                }
                // if first node is the only node in the list
                if (head.next == null) {
                    head = null;
                    return;
                }
            }

            // else, traverse till last's next && data not get found
            while (curr != null && curr.data != data) {
                // set prev and curr pointer accordingly
                prev = curr;
                curr = curr.next;
            }
            // if data found
            if (curr != null) {
                prev.next = curr.next;
                return;
            }
            // if data not found
            if (curr == null) {
                System.out.println("Data not found!");
                return;
            }
        }

        public void removeAt(int index) {
            node curr = head;
            node prev = null;
            // if list is empty
            if (head == null) {
                System.out.println("List is empty!");
                return;
            }
            // if invalid index
            if (index < 0) {
                System.out.println("Invalid index!!");
                return;
            }
            // if first element to be removed
            if (index == 0) {
                // if list contains more than one element
                if (curr.next != null) {
                    head = curr.next;
                    return;
                }
                // if first node is the only element
                if (curr.next == null) {
                    head = null;
                    return;
                }
            }
            int i = 0;
            // else, traverse till last element
            // and increment i
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
                i++;
                // if index found
                if (i == index) {
                    prev.next = curr.next;
                    return;
                }
            }
            // if index not found till the last
            if (i != index) {
                System.out.println("No such index!!");
                return;
            }
        }

        public int size() {
            // if list is empty
            if (head == null) {
                return 0;
            }
            int i = 1;
            node temp = head;
            // loop till last element along with the i increment
            while (temp.next != null) {
                temp = temp.next;
                i++;
            }
            return i;
        }

        public void display() {
            // if head is null
            if (head == null) {
                System.out.println("List is Empty!!");
                return;
            }
            node temp = head;
            // else,loop through the last element till null
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("NULL");
        }

        public void printUsingRecursion(node head) {
            if (head == null)
                return;
            System.out.print(head.data + "->");
            printUsingRecursion(head.next);
        }

        public void printReverseRecursion(node head) {
            if (head == null)
                return;
            printReverseRecursion(head.next);
            System.out.print(head.data + "  ");
        }

        public void reverseIterative() {
            if (head == null) {
                System.out.println("List is Empty!");
                return;
            }
            node curr = head; // to point current node
            node prev = null; // to point previous node
            node nextAdd; // to store next's address, so that we do not loose it while
                          // shifting the links as it is needed to move curr one node forward.
            while (curr != null) { // loop till last
                nextAdd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextAdd;
            }
            // now point head to prev(last node), as it will point to the last node and curr
            // will point to null.
            head = prev;
        }

        public void reverseRecursive(node temp) {
            // if list is empty.
            if (head == null) {
                return;
            }
            // base condition to make point last node to head
            if (temp.next == null) {
                head = temp;
                return;
            }
            reverseRecursive(temp.next);
            /*
             * we can even do :
             * 
             * temp.next.next = temp; temp.next = null;
             * 
             */
            // now after recursion and base condition the temp will point to the second last
            // node,
            // create one pointer to point the node next to temp,
            node prev = temp.next;
            // no shift links,
            // initialize prev to temp's next and temp's next to null
            prev.next = temp;
            temp.next = null;
        }

        public boolean isEmpty() {
            return head==null;
        }

}
