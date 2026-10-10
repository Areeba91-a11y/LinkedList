package datastructures;

import java.util.NoSuchElementException;

/**
 * Singly linked list with head and tail pointers.
 * Supports insertion, deletion and search at the front, end, or any index.
 *
 * @param <T> element type
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ---------- Insert operations ----------

    /** Inserts at the front. O(1). */
    public void insertAtFront(T element) {
        Node<T> node = new Node<>(element, head);
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    /** Inserts at the end. O(1) thanks to the tail pointer. */
    public void insertAtEnd(T element) {
        Node<T> node = new Node<>(element);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /** Inserts at the given index (0..size). O(n). */
    public void insertAt(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            insertAtFront(element);
        } else if (index == size) {
            insertAtEnd(element);
        } else {
            Node<T> prev = nodeAt(index - 1);
            prev.next = new Node<>(element, prev.next);
            size++;
        }
    }

    // ---------- Delete operations ----------

    /** Removes and returns the first element. O(1). */
    public T removeFromFront() {
        requireNonEmpty();
        T value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    /** Removes and returns the last element. O(n) in a singly linked list. */
    public T removeFromEnd() {
        requireNonEmpty();
        if (head == tail) {
            return removeFromFront();
        }
        Node<T> prev = nodeAt(size - 2);
        T value = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return value;
    }

    /** Removes and returns the element at the given index. O(n). */
    public T removeAt(int index) {
        checkIndex(index);
        if (index == 0) {
            return removeFromFront();
        }
        if (index == size - 1) {
            return removeFromEnd();
        }
        Node<T> prev = nodeAt(index - 1);
        Node<T> target = prev.next;
        prev.next = target.next;
        size--;
        return target.data;
    }

    /** Removes the first occurrence of the value. Returns true if found. */
    public boolean removeByValue(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    // ---------- Search / access ----------

    /** Linear search. Returns index of first match or -1. */
    public int indexOf(T element) {
        int i = 0;
        for (Node<T> cur = head; cur != null; cur = cur.next, i++) {
            if (element == null ? cur.data == null : element.equals(cur.data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public T get(int index) {
        checkIndex(index);
        return nodeAt(index).data;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    // ---------- Helpers ----------

    private Node<T> nodeAt(int index) {
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void requireNonEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        return sb.append("null").toString();
    }
}
