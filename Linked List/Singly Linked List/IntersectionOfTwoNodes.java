/*
 * Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

Examples:

Example 1:
Input:
List 1 = [1,3,1,2,4], List 2 = [3,2,4]
Output:
2
Explanation: Here, both lists intersecting nodes start from node 2.

Example 2:
Input:
 List1 = [1,2,7], List 2 = [2,8,1]
Output:
 Null
Explanation: Here, both lists do not intersect and thus no intersection node is present.
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

public class IntersectionOfTwoNodes {

    public static void findIntersectNode(Node head1,Node head2) {
        Node dummy1 = head1, dummy2 = head2;
        while(dummy1 != dummy2) {
            dummy1 = dummy1 == null ? head2 : dummy1.next;
            dummy2 = dummy2 == null ? head1 : dummy2.next;
        }
        System.out.println(dummy1.data);
    }

    public static void main(String [] args) {
        int a[] = {1, 2, 4, 3};
        int b[] = {5, 12};
        int c[] = {7, 9, 11}; 
        Node head1 = Node.createList(a);
        Node inter = new Node(6, null);
        Node head2 = Node.createList(b);
        Node common = Node.createList(c);
        head1.next.next.next.next = inter;
        head2.next.next = inter;
        inter.next = common;
        System.out.println("First list ");
        Node.printNode(head1);
        System.out.println("Second list ");
        Node.printNode(head2);
        findIntersectNode(head1, head2);
    }
}