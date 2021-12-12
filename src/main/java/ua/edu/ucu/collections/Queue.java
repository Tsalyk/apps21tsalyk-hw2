package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        return queue.getHead().getValue();
    }

    public Object dequeue() {

        Object head = queue.getHead().getValue();
        queue.removeFirst();

        return head;
    }

    public void enqueue(Object e) {
        queue.add(e);
    }

}

