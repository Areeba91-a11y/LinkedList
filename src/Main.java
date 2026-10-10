import linkedlist.LinkedQueue;
import linkedlist.LinkedStack;
import linkedlist.SinglyLinkedList;

/** Demo runner for the linked-list based data structures. */
public class Main {

    public static void main(String[] args) {
        demoList();
        demoStack();
        demoQueue();
    }

    private static void demoList() {
        System.out.println("=== Singly Linked List ===");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtFront(10);
        list.insertAt(2, 25);
        System.out.println("After inserts  : " + list);
        System.out.println("Contains 30?   : " + list.contains(30));
        list.removeAt(2);
        list.removeFromFront();
        list.removeFromEnd();
        System.out.println("After removals : " + list);
        System.out.println();
    }

    private static void demoStack() {
        System.out.println("=== Linked Stack ===");
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack + " | peek = " + stack.peek());
        System.out.println("Popped: " + stack.pop() + " -> " + stack);
        System.out.println();
    }

    private static void demoQueue() {
        System.out.println("=== Linked Queue ===");
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue + " | peek = " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue() + " -> " + queue);
    }
}
