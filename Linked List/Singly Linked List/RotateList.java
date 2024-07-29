/*
 * Problem Statement: Given the head of a linked list, rotate the list to the right by k places.

Examples:

Example 1:
Input:
	head = [1,2,3,4,5] 
	k = 2
Output:
 head = [4,5,1,2,3]
Explanation:
 We have to rotate the list to the right twice.

 Example 2:
Input:
	head = [1,2,3]
	k = 4
Output:
head = [3,1,2]
Explanation:
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

        for(int i = 1; i < a.length; i ++) {
            Node newNode = new Node(a[i], null);
            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }

    public static void printNode(Node n) {
        while(n != null) {
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

public class RotateList {

    public static Node rotate(Node head, int k) {
        Node temp = head;
        int len = 1;

        while(temp.next != null) {
            len++;
            temp = temp.next;
        }

        temp.next = head;
        k = k%len;
        int end = len - k;

        while(end != 0) {
            temp = temp.next;
            end--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    public static void main(String [] args) {
        int a[] = {1, 3, 5, 7, 4};
        int k = 2;
        Node head = Node.createList(a);
        System.out.println("Original list ");
        Node.printNode(head);
        System.out.println("After rotating ");
        head = rotate(head, k);
        Node.printNode(head);
    }
}