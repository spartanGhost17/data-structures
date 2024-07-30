package dataStructures.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void swapPairs() {
        if(this.length == 0 || this.length == 1) return;
        Node left = this.head, right = left.next;
        int leftVal = 0, rightVal = 0;

        for(int i = 0; i < this.length - 1; i+=2) {
            leftVal = left.value;
            rightVal = right.value;

            left.value = rightVal;
            right.value = leftVal;

            if(left.next.next != null) {
                left = left.next.next;
                right = left.next;
            }
        }
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > this.length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == this.length) {
            append(value);
            return true;
        }
        Node node = new Node(value);
        Node before = get(index - 1);
        Node after  = before.next;
        node.prev = before;
        node.next = after;
        before.next = node;
        after.prev = node;
        this.length++;
        return true;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public Node get(int index) {
        if(index < 0 || index >= this.length) return null;
        Node temp = this.head;
        if(index < this.length/2) {
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for(int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.length++;
    }

    public void append(int value) {
        Node node = new Node(value);
        if(this.head == null) {
            this.head = node;
            //this.tail = node;
        } else {
            //Node temp = this.tail;
            this.tail.next = node;
            node.prev = this.tail;
            //this.tail = node;
        }
        this.tail = node;
        this.length++;
    }

    public Node remove(int index) {
        if(index < 0 || index >= this.length) return null;
        if(index == 0) return removeFirst();
        if(index == this.length - 1) return removeLast();

        Node temp = get(index);

        Node before = temp.prev;
        Node after = temp.next;

        before.next = after;
        after.prev = before;
        temp.next = null;
        temp.prev = null;
        this.length--;
        return temp;
    }

    public Node removeFirst() {
        if(this.head == null) {
            return null;
        }
        Node temp = this.head;
        if( this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
            temp.next = null;
        }
        this.length--;
        return temp;
    }

    public Node removeLast() {
        if(this.head == null) {
            return null;
        }
        Node temp = this.tail;
        if(this.length ==  1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node iterator = this.head;
        while(iterator.next != null) {
            sb.append(" N["+iterator.value+"] ");
            iterator = iterator.next;
        }
        sb.append(" N["+this.tail.value+"] ");
        return sb.toString();
    }
}
