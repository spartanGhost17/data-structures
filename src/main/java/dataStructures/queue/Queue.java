package dataStructures.queue;

import dataStructures.stack.Stack;

public class Queue {
    private Node first;
    private Node last;
    private int length;
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node node = new Node(value);
        this.first = node;
        this.last = node;
        this.length = 1;
    }

    public Node dequeue() {//remove first
        if(this.first == null) return null;
        Node temp = this.first;
        if(this.length == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = temp.next;
            temp.next = null;
        }
        this.length--;
        return temp;
    }

    public void enqueue(int value) { //linkedList prepend
        Node node = new Node(value);
        if(this.first == null) {
            this.first = node;
            //this.last = node;
        } else {
            Node temp = this.last;
            temp.next = node;
            //this.last = node;
        }
        this.last = node;
        this.length++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node iterator = this.first;
        while(iterator != null) {
            sb.append(" N["+iterator.value+"] ");
            iterator = iterator.next;
        }
        return sb.toString();
    }
}
