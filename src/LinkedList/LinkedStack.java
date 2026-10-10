package datastructures;

import java.util.EmptyStackException;

/**
 * Unbounded stack (LIFO) implemented with a singly linked list.
 * The top of the stack is the head of the list, so every operation is O(1).
 *
 * @param <T> element type
 */
public class LinkedStack<T> {

    private Node<T> top;
    private int size;

    public void push(T element) {
        top = new Node<>(element, top);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("top -> ");
        for (Node<T> cur = top; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        return sb.append("null").toString();
    }
}
