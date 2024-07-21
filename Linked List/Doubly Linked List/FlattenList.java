/*
 * Problem Statement: Given a linked list containing ‘N’ head nodes where every node in the linked list contains two pointers:

‘Next’ points to the next node in the list
‘Child’ pointer to a linked list where the current node is the head
Each of these child linked lists is in sorted order and connected by a 'child' pointer. 
Your task is to flatten this linked list such that all nodes appear in a single layer or level in a 'sorted order'.

Example 1:
Input:
  3 -> 2 -> 1 -> 4 -> 5
       I    I    I    I
      10    7    9    6
            I         I
            11        8
            I
            12

Output:1 2 3 4 5 6 7 8 9 10 11 12

Explanation: Flatten the linked list into a single level sorted order and traverse the nodes in such a manner that 
the child linked lists are merged into the main list in the sorted order.

 */
class Node {
    int data;
    Node next;
    Node child;

    Node(int data, Node child) {
        this.data = data;
        this.child = child;
    }

    public static Node createList(int a[]) {
        Node head = new Node(a[0], null);
        Node temp = head;

        for (int i = 1; i < a.length; i++) {
            Node newNode = new Node(a[i], null);
            temp.child = newNode;
            temp = newNode;
        }

        return head;
    }

    public static void printNode(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.child;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Node [ data = " + this.data + ", address = " + this.next + " ] ";
    }
}

public class FlattenList {

    public static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergeHead = flatten(head.next);
        head = merge(head, mergeHead);
        return head;
    }

    public static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1, null);
        Node res = dummy;

        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                res.child = head1;
                res = head1;
                head1 = head1.child;
            }
            else {
                res.child = head2;
                res = head2;
                head2 = head2.child;
            }
            res.next = null;
        }

        if(head1 != null) {
            res.child = head1;
        }
        else {
            res.child = head2;
        }

        return dummy.child;
    }

    public static void main(String[] args) {
        int a[] = { 3 };
        int b[] = { 2, 10 };
        int c[] = { 1, 7, 11, 12 };
        int d[] = { 4, 9 };
        int e[] = { 5, 6, 8 };

        Node head1 = Node.createList(a);
        Node head2 = Node.createList(b);
        Node head3 = Node.createList(c);
        Node head4 = Node.createList(d);
        Node head5 = Node.createList(e);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        Node head = flatten(head1);
        Node.printNode(head);
    }
}
