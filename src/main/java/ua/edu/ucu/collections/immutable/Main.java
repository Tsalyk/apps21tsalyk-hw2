package ua.edu.ucu.collections.immutable;


public class Main {
    public static void main(String[] args) {
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        immutableLinkedList.add(1);
        immutableLinkedList.add(10);
        System.out.println(immutableLinkedList.get(1));
    }
}
