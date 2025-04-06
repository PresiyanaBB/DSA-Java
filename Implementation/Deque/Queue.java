package Implementation.Deque;

public class Queue {
    private Node front, rear;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear != null) rear.next = newNode;
        rear = newNode;
        if (front == null) front = newNode;
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    public int peek() {
        if (front == null) throw new RuntimeException("Queue is empty");
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

