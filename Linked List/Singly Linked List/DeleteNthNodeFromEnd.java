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

public class DeleteNthNodeFromEnd {

    public static Node deleteNode(Node head, int n) {
        Node slow = head;
        Node fast = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;

        return head;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 11, 16};
        int n = 2;
        Node head = Node.createList(a);
        Node.printNode(head);
        head = deleteNode(head, n);
        Node.printNode(head);
    }
}