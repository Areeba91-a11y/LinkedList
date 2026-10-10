# Java Linked List Data Structures

Generic, well-documented linked-list based data structures in Java.

## Structure
```
src/
├── Main.java                   # demo runner
└── linkedlist/
    ├── Node.java               # list node
    ├── SinglyLinkedList.java   # singly linked list (head + tail)
    ├── LinkedStack.java        # stack (LIFO) using linked list
    └── LinkedQueue.java        # queue (FIFO) using linked list
```

## Operations

**SinglyLinkedList**: insert at front / end / index, remove from front / end / index, remove by value, search (`indexOf`, `contains`), `get`, `clear`

**LinkedStack**: `push`, `pop`, `peek`, `isEmpty`, `size`

**LinkedQueue**: `enqueue`, `dequeue`, `peek`, `isEmpty`, `size`

## Run
```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```
