package ua.edu.ucu.collections.immutable;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList immutableLinkedList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        immutableLinkedList = new ImmutableLinkedList();
        immutableLinkedList.add(1);
    }

    @org.junit.jupiter.api.Test
    void add() {
        immutableLinkedList.add(2);
        assertEquals(2, immutableLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        immutableLinkedList.add(1, 2);
        assertEquals(2, immutableLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        Object[] arr = new Object[]{1, 2, 3, 4, 5};
        immutableLinkedList.addAll(arr);
        assertEquals(6, immutableLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void testAddAll() {
        immutableLinkedList.add(10);
        Object[] arr = new Object[]{1, 2, 3, 4, 5};
        immutableLinkedList.addAll(1, arr);
        assertEquals(7, immutableLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
        immutableLinkedList.add(10);
        Node res = (Node) immutableLinkedList.get(1);
        assertEquals(10, res.getValue());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        immutableLinkedList.add(10);
        immutableLinkedList.remove(0);
        Node res = (Node) immutableLinkedList.get(0);
        assertEquals(10, res.getValue());
    }

    @org.junit.jupiter.api.Test
    void set() {
        immutableLinkedList.set(0, 10);
        Node res = (Node) immutableLinkedList.get(0);
        assertEquals(10, res.getValue());
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            immutableLinkedList.add(i);
        }

        assertEquals(3, immutableLinkedList.indexOf(3));
    }

    @org.junit.jupiter.api.Test
    void size() {
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            immutableLinkedList.add(i);
        }

        assertEquals(6, immutableLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        assertEquals(1, immutableLinkedList.size());
        immutableLinkedList.clear();
        assertEquals(0, immutableLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(false, immutableLinkedList.isEmpty());
        immutableLinkedList.clear();
        assertEquals(true, immutableLinkedList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        immutableLinkedList.add(10);
        Object[] arr = immutableLinkedList.toArray();

        assertEquals(10, ((Node)arr[1]).getValue());
    }

    @org.junit.jupiter.api.Test
    void addFirst() {
        immutableLinkedList.addFirst(10);
        assertEquals(10, ((Node)immutableLinkedList.getHead()).getValue());
    }

    @org.junit.jupiter.api.Test
    void addLast() {
        immutableLinkedList.addLast(10);
        assertEquals(10, ((Node)immutableLinkedList.getTail()).getValue());
    }

    @org.junit.jupiter.api.Test
    void getHead() {
        assertEquals(1, ((Node)immutableLinkedList.getHead()).getValue());
    }

    @org.junit.jupiter.api.Test
    void getTail() {
        immutableLinkedList.add(10);
        assertEquals(10, ((Node)immutableLinkedList.getTail()).getValue());
    }

    @org.junit.jupiter.api.Test
    void getFirst() {
        assertEquals(1, ((Node)immutableLinkedList.getFirst()).getValue());
    }

    @org.junit.jupiter.api.Test
    void getLast() {
        immutableLinkedList.add(10);
        assertEquals(10, ((Node)immutableLinkedList.getLast()).getValue());
    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
        immutableLinkedList.add(10);
        immutableLinkedList.removeFirst();
        assertEquals(10, ((Node)immutableLinkedList.getFirst()).getValue());
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        immutableLinkedList.add(10);
        immutableLinkedList.removeLast();
        assertEquals(1, ((Node)immutableLinkedList.getFirst()).getValue());
    }
}