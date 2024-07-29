/*
 * Problem Statement: Given the heads of two non-empty linked lists representing two non-negative 
 * integers. The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.

Examples:

Input Format: 
(Pointer/Access to the head of the two linked lists)

num1  = 243, num2 = 564

l1 = [2,4,3]
l2 = [5,6,4]

Result: sum = 807; L = [7,0,8]

Explanation: Since the digits are stored in reverse order, reverse the numbers 
first to get the or original number and then add them as → 342 + 465 = 807. 
Refer to the image below.

Input Format: 
(Pointer/Access to the head of the two linked lists)

l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]

Result: [8,9,9,9,0,0,0,1]

Explanation: Since the digits are stored in reverse order, 
reverse the numbers first to get the original number and then add 
them as → 9999999 + 9999 = 8999001
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

public class Add2Numbers {

    public static Node add(Node head1, Node head2) {
        int sum, carry = 0;
        Node dummy = new Node(-1, null);
        Node temp = dummy;
        while(head1 != null || head2 != null || carry == 1) {
            sum = 0;
            if(head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if(head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            Node nn = new Node(sum%10, null);
            temp.next = nn;
            temp = temp.next;
            carry = sum/10;
        }

        return dummy.next;
    }

    public static void main(String [] args) {
        int a[] = {2, 4, 3};
        int b[] = {5, 6, 4};
        Node head1 = Node.createList(a);
        Node head2 = Node.createList(b);
        System.out.println("First number");
        Node.printNode(head1);
        System.out.println("Second number");
        Node.printNode(head2);
        Node head = add(head1, head2);
        Node.printNode(head);
    }
}