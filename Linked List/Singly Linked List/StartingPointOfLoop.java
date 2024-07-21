/*
 * Problem Statement: Given the head of a linked list that may contain a cycle, return the starting point of that cycle. 
 * If there is no cycle in the linked list return null.
 * 
 * Examples
Example 1:
Input: LL: 1  2  3  4  5 

Output: 3
Explanation: This linked list contains a loop of size 3 starting at node with value 3.
Example 2:
Input: LL: LL: 1 -> 2 -> 3 -> 4 -> 9 -> 9
                
Output: NULL
Explanation:  This linked list does not contain  a loop hence has no starting point. 
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

public class StartingPointOfLoop {

    public static void detectStartPt(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                System.out.println(slow.data);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 3, 2 };
        int b[] = { 5, 7, 9 };
        Node inter = new Node(6, null);
        Node head1 = Node.createList(a);
        Node head2 = Node.createList(b);
        head1.next.next.next = inter;
        inter.next = head2;
        head2.next.next.next = inter;
        detectStartPt(head1);
    }
}
