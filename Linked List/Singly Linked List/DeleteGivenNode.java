/*
 * Problem Statement: Write a function to delete a node in a singly-linked list. 
 * You will not be given access to the head of the list instead, 
 * you will be given access to the node to be deleted directly. 
 * It is guaranteed that the node to be deleted is not a tail node in the list.

Examples:

Example 1:
Input:
 Linked list: [1,4,2,3]
       Node = 2
Output:
Linked list: [1,4,3]
Explanation: Access is given to node 2. After deleting nodes, 
the linked list will be modified to [1,4,3].

Example 2:
Input:
 Linked list: [1,2,3,4]
       Node = 1
Output: Linked list: [2,3,4]
Explanation:
 Access is given to node 1. After deleting nodes, 
 the linked list will be modified to [2,3,4].
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

public class DeleteGivenNode {

    public static void deleteNode(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    public static void main(String [] args) {
        int a[] = {1, 2, 3, 4, 5};
        Node head = Node.createList(a);
        System.out.println("Before deleting");
        Node.printNode(head);
        Node delNode = head.next.next;
        System.out.println("After deleting");
        deleteNode(delNode);
        Node.printNode(head);   
    }
}