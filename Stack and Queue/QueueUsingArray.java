class Queue {
    private int [] queue;
    private int front, rear, capacity, size;

    Queue(int capacity) {
        queue = new int[capacity];
        this.capacity = capacity;
        front = -1;
        rear = -1;
    }

    public void enqueue(int element) {
        System.out.print(capacity + " " + size);
        if(isFull()) {
            System.out.println("Can't push elements into queue");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.print("Can't pop elements from queue");
            return;
        }

        front = (front + 1) % capacity;
        size--;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.print("Can't peek elements from queue");
            return -1;
        }
        System.out.println(front);
        return queue[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class QueueUsingArray {
    public static void main(String [] args) {
        Queue queue = new Queue(6); 

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); 

        System.out.println(queue.peek() + " is at the front of the queue.");

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.peek() + " is at the front of the queue after dequeuing.");

        System.out.println("Queue size: " + queue.size());
    }
}