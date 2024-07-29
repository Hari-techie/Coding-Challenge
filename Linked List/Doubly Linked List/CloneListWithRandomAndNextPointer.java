/*
 * Problem Statement: Given a linked list where every node in the linked list contains two pointers:

‘next’ which points to the next node in the list.
‘random’ which points to a random node in the list or ‘null’.
Create a ‘deep copy’ of the given linked list and return it.

Examples
Example 1:
Input:
    7 -> 13 -> 11 -> 10 -> 1
    I     I     I     I    I
    null  7     1     11    7
 */
class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
    }

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

public class CloneListWithRandomAndNextPointer {

    public static Node createRandomList() {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b;
        a.random = null;
        b.next = c;
        b.random = a;
        c.next = d;
        c.random = e;
        d.next = e;
        d.random = c;
        e.random = a;

        return a;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print("Current Data : " + head.data);
            if (head.random != null) {
                System.out.print(" - Random Data : " + head.random.data);
            } else {
                System.out.print(" - No Random Data");
            }
            System.out.println();
            head = head.next;
        }
    }

    public static Node clone(Node head) {

        // Create a clone of each node and store it as next node
        Node temp = head;
        while (temp != null) {
            Node nn = new Node(temp.data);
            nn.next = temp.next;
            temp.next = nn;
            temp = temp.next.next;
        }

        // Assign random node for cloned list
        temp = head;
        while (temp != null) {
            Node cloneNode = temp.next;
            if (temp.random != null) {
                cloneNode.random = temp.random.next;
            } else {
                cloneNode.random = null;
            }
            temp = temp.next.next;
        }

        // Assign Next properly
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = createRandomList();
        System.out.println("----------------Before cloning--------------");
        printList(head);
        System.out.println("----------------After cloning---------------");
        Node newHead = clone(head);
        printList(newHead);
    }
}
