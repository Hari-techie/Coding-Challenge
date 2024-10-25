class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; 
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow: Unable to push " + value);
            return;
        }
        stack[++top] = value; 
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Unable to pop");
            return -1; 
        }
        return stack[top--]; 
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; 
        }
        return stack[top]; 
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Unable to print");
            return; 
        }
        System.out.println("Stack elements : ");
        for(int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is: " + stack.peek());
        stack.print(); 
        
        System.out.println("Stack size: " + stack.size()); 

        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Top element is: " + stack.peek()); 
    }
}
