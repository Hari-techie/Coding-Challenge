/*
 * Detect a Cycle in a Linked List
 * 
 * Examples
Example 1:

Input Format:

LL: 1 2 3 4 5

Result: True

Explanation: The last node with the value of 5 has its 'next' pointer pointing back to a previous node with the value of 3. This has resulted in a loop, hence we return true.

Example 2:

Input Format:

LL: 1 2 3 4 9 9

Result: False

Explanation: : In this example, the linked list does not have a loop hence returns false.
 */
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node createList(int a[]) {
        Node head = new Node(a[0], null);
        Node temp = head;

        for (int i = 1; i < a.length; i++) {
            Node newNode = new Node(a[i], null);
            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }

    public static void printNode(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Node [ data = " + this.data + ", address = " + this.next + " ] ";
    }
}

public class DetectCycleInList {

    public static void detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                System.out.println(slow.data);
                break;
            }
        }
    }

    public static void main(String [] args) {
        int a[] = {1, 2, 4, 3};
        int b[] = {5, 12, 7};
        Node head1 = Node.createList(a);
        Node inter = new Node(6, null);
        Node head2 = Node.createList(b);
        head1.next.next.next.next = inter;
        inter.next = head2;
        head2.next.next.next = inter;
        detectCycle(head1);
    }
}