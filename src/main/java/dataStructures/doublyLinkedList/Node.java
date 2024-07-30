package dataStructures.doublyLinkedList;

public class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
