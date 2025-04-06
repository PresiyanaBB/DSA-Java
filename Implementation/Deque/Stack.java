package Implementation.Deque;

public class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack is empty");
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

