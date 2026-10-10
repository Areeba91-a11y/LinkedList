package datastructures;

import java.util.NoSuchElementException;

/**
 * Unbounded queue (FIFO) implemented with a singly linked list.
 * Enqueue happens at the tail, dequeue at the head, so both are O(1).
 *
 * @param <T> element type
 */
public class LinkedQueue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public void enqueue(T element) {
        Node<T> node = new Node<>(element);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("front -> ");
        for (Node<T> cur = front; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        return sb.append("rear").toString();
    }
}
