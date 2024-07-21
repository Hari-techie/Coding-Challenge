/*
 * Problem Statement: Given the head of a singly linked list of `n` nodes and an integer `k`, where k is less than or equal to `n`. Your task is to reverse the order of each group of `k` consecutive nodes, if `n` is not divisible by `k`, then the last group of remaining nodes should remain unchanged.

Examples
Example 1:

Input Format:

LL: 1  2  3  4  5  6  7  8  9  10
K = 3

Explanation:

Group 1: Reverse nodes 1 -> 2 -> 3 to become 3 -> 2 -> 1.
Group 2: Reverse nodes 4 -> 5 -> 6 to become 6 -> 5 -> 4.
Group 3: Reverse nodes 7 -> 8 -> 9 to become 9 -> 8 -> 7.
Node 10 remains as is since there are no more groups of size K remaining.

Output: 3  2  1  6  5  4  9  8  7  10


Example 2:

Input Format:

LL: 5  4  3  7  9  2

K = 4

Output: 7 3 4 5 9 2

Explanation: 

Group 1: Reversed nodes 5 -> 4 -> 3 -> 7 to become 7 -> 3 -> 4 -> 5.
Group 2: Nodes 9 -> 2 remain unchanged as they are not a complete group of size K.

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

public class ReverseListOfGivenKSize {

    public static Node reverse(Node head) {
        Node temp = head, prev = null, next = null;

        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public static Node getKthNode(Node n, int k) {
        k--;

        while(n != null && k > 0) {
            n = n.next;
            k--;
        }

        return n;
    }

    public static Node reverseNodes(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        
        while(temp != null) {
            Node kthNode = getKthNode(temp, k);

            if(kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head) {
                head = kthNode;
            }
            else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 4, 8, 11, 5};
        int k = 3;
        Node head = Node.createList(a);
        System.out.println("Original list ");
        Node.printNode(head);
        System.out.println("After reversing ");
        head = reverseNodes(head, k);
        Node.printNode(head);
    }
}
