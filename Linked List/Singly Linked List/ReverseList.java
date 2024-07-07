
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

public class ReverseList {

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

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 4};
        Node head = Node.createList(a);
        System.out.println("Original list ");
        Node.printNode(head);
        System.out.println("After reversing ");
        head = reverse(head);
        Node.printNode(head);
    }
}
