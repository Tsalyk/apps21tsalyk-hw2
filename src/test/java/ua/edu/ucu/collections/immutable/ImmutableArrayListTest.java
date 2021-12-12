package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableArrayListTest {
    ImmutableArrayList immutableArrayList;

    @BeforeEach
    void setUp() {
        immutableArrayList = new ImmutableArrayList(new Object[]{1, 3, 8});
    }

    @Test
    void add() {
        immutableArrayList.add(10);
        assertEquals(4, immutableArrayList.size());
    }

    @Test
    void testAdd() {
        immutableArrayList.add(2, 10);
        assertEquals(10, immutableArrayList.get(2));
    }

    @Test
    void addAll() {
        immutableArrayList.addAll(new Object[]{2, 10, 20});
        assertEquals(6, immutableArrayList.size());
    }

    @Test
    void testAddAll() {
        immutableArrayList.addAll(2, new Object[]{2, 10, 20});
        assertEquals(6, immutableArrayList.size());
    }

    @Test
    void get() {
        assertEquals(3, immutableArrayList.get(1));
    }

    @Test
    void remove() {
        immutableArrayList.remove(1);
        assertEquals(8, immutableArrayList.get(1));
    }

    @Test
    void set() {
        immutableArrayList.set(2, 12);
        assertEquals(12, immutableArrayList.get(2));
    }

    @Test
    void indexOf() {
        assertEquals(2, immutableArrayList.indexOf(8));
    }

    @Test
    void size() {
        assertEquals(3, immutableArrayList.size());
    }

    @Test
    void clear() {
        assertEquals(3, immutableArrayList.size());
        immutableArrayList.clear();
        assertEquals(0, immutableArrayList.size());
    }

    @Test
    void isEmpty() {
        assertEquals(false, immutableArrayList.isEmpty());
        immutableArrayList.clear();
        assertEquals(true, immutableArrayList.isEmpty());
    }

    @Test
    void toArray() {
        Object[] array = immutableArrayList.toArray();
        assertEquals(array.length, immutableArrayList.size());
        assertEquals(array[2], immutableArrayList.get(2));
    }
}