package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        stack.add(e);
    }

    public Object pop() {

        Object tail = stack.getTail().getValue();
        stack.removeLast();

        return tail;
    }

    public Object peek() {

        return stack.getTail().getValue();
    }
}
