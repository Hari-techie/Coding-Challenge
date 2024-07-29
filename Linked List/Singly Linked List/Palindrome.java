
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

public class Palindrome {
    public static Node reverse(Node head) {
        Node temp = head, prev = null, next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public static Node getMidNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void isPalindrome(Node head) {
        Node mid = getMidNode(head);
        Node newMid = reverse(mid.next);
        Node first = head;
        Node second = newMid;
        int flag = 1;
        while(second != null) {

            if(first.data != second.data) {
                reverse(newMid);
                System.out.println("Not a palindrome");
                flag = 0;
                break;
            }

            first = first.next;
            second = second.next;
        }

        if(flag == 1) {
            reverse(newMid);
            System.out.println("Palindrome");
        }
    }

    public static void main(String[] args) {
        // int a[] = { 1, 3, 5, 3, 1 };
        int a[] = {1, 2 , 3, 3, 2, 0};
        Node head = Node.createList(a);
        System.out.println("Original list ");
        Node.printNode(head);
        isPalindrome(head);
    }
}
