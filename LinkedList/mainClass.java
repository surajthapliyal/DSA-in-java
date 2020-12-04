package LinkedList;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList ll = new MyLinkedList();
        System.out.println("Linked List operations are : ");
        int choice = 0;
        do {
            System.out.println("\n1.Append.");
            System.out.println("2.Add at a specified index.");
            System.out.println("3.Remove specified data.");
            System.out.println("4.Remove data at a specified index.");
            System.out.println("5.Display.");
            System.out.println("6.Display list using recursion.");
            System.out.println("7.Display list in reverse using recursion.");
            System.out.println("8.Display  list in reverse using iteration(actual reversal).");
            System.out.println("9.Display  list in reverse using recursion(actual reversal).");
            System.out.println("10.Display Size.");
            System.out.println("11.Is Empty?");
            System.out.println("12.Exit!\n");

            System.out.print("Enter your choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to append = ");
                    int d1 = sc.nextInt();
                    ll.append(d1);
                    break;
                case 2:
                    System.out.print("Enter index and data = ");
                    int index = sc.nextInt();
                    int d2 = sc.nextInt();
                    ll.addAt(index, d2);
                    break;
                case 3:
                    System.out.print("Enter specific data to remove = ");
                    int d3 = sc.nextInt();
                    ll.remove(d3);
                    break;
                case 4:
                    System.out.print("Enter index = ");
                    int i = sc.nextInt();
                    ll.removeAt(i);
                    break;
                case 5:
                    ll.display();
                    break;
                case 6:
                    ll.printUsingRecursion(ll.head);
                    break;
                case 7:
                    ll.printReverseRecursion(ll.head);
                    break;
                case 8:
                    ll.reverseIterative();
                    break;
                case 9:
                    ll.reverseRecursive(ll.head);
                    ll.display();
                    break;
                case 10:
                    System.out.println(ll.size());
                    break;
                case 11:
                    if(ll.isEmpty()) System.out.println("YES");
                    else System.out.println("NO");
                    break;
                case 12:
                    System.out.println("Program terminated!!");
                    System.exit(1);
                default:
                    System.out.println("Invalid !! Please enter valid choice!!");
                    break;
            }
        } while (choice != 12);
        sc.close();
    }
}
