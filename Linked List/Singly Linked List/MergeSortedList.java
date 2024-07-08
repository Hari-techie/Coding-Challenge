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

public class MergeSortedList {

    public static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1, null);
        Node temp = dummy;

        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if(head1 != null) {
            temp.next = head1;
        }
        else {
            temp.next = head2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7};
        int b[] = {2, 6, 9, 11, 13};
        Node head1 = Node.createList(a);
        Node head2 = Node.createList(b);
        Node.printNode(head1);
        Node.printNode(head2);
        Node head = merge(head1, head2);
        Node.printNode(head);
    }
}
