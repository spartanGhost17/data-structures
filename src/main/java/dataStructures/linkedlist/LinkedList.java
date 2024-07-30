package dataStructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    public LinkedList(int value) {
        //create new Node
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * reorder linkedList based on x
     * @param x the cutting point
     */
    public void partitionList(int x) {
        if (head == null || head.next == null) {
            // Empty list or single node, no changes needed
            return;
        }

        // Initialize two separate lists for smaller and greater/equal values
        Node smallerHead = null, smallerLast = null;
        Node greaterHead = null, greaterLast = null;

        // Traverse the original list
        while (head != null) {
            if (head.value < x) {
                // Node with value less than x
                if (smallerHead == null) {
                    smallerHead = smallerLast = head;
                } else {
                    smallerLast.next = head;
                    smallerLast = head;
                }
            } else {
                // Node with value greater than or equal to x
                if (greaterHead == null) {
                    greaterHead = greaterLast = head;
                } else {
                    greaterLast.next = head;
                    greaterLast = head;
                }
            }
            this.head = head.next;
        }

        // Connect the two lists
        if (smallerHead != null) {
            smallerLast.next = greaterHead;
        } else {
            smallerHead = greaterHead;
        }

        // Set the last node of the greater list to null
        if (greaterLast != null) {
            greaterLast.next = null;
        }

        this.head = smallerHead;
        this.tail = greaterLast;
    }

    /**
     * has a cycle
     * @return
     */
    public boolean hasLoop() {
        if(this.head == null || this.head.next == null) return false;
        Node slow = this.head;
        Node fast = slow.next.next;

        while(fast != null && fast.next != null){
            if(slow == fast) {
                return true; //cycle detected
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * add at the end
     * @param value
     */
    public void append(int value) {
        //create new Node
        //add Node to end
        Node node = new Node(value);
        if(this.length == 0){
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.length +=1;
    }

    /**
     * add at the start
     * @param value
     */
    public void prepend(int value) {
        //create new Node
        //add Node to start
        Node node = new Node(value);
        Node temp = this.head;
        if(this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = temp;
            this.head = node;
        }
        this.length++;
    }

    public boolean set(int index, int value) {
        Node temp = this.head;
        Node node = get(index);
        if(node == null) {
            return false;
        }
        node.value = value;
        return true;
    }

    public Node get(int index) {
        if(index < 0 || index >= this.length) {//>=?
            return null;
        }
        Node temp = this.head;
        for(int i = 0; i < this.length; i++) {
            if(index == i) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }

    /**
     * insert value anywhere in the list
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {//O(n)
        //create Node
        //insert Node at index
        if(index < 0 || index > this.length) return false;

        if(index == 0) {
            prepend(value);
            return true;
        }

        if(index == length) {
            append(value);
            return true;
        }

        Node node = new Node(value);
        Node temp = get(index - 1);
        node.next = temp.next;
        temp.next = node;
        this.length++;
        return true;
    }

    /**
     * reverse a linked
     * */
   public void reverse() {
        //if(this.length == 0) return;
        //if(this.length == 1) return;
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node after = null;//temp.next;
        Node before = null;

        for(int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
   }

    public Node remove(int index) {
        if(index < 0 || index >= this.length) {
            return null;
        }

        if(index == 0) {
            return removeFirst();
        }

        if(index == this.length - 1) {
            return removeLast();
        }

        Node node = get(index - 1);
        Node temp = node.next;
        node.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public Node removeFirst(){
        Node temp = this.head;
        if(this.length == 0) {
            return null;
        }

        this.head = temp.next;
        temp.next = null;
        this.length--;
        if(this.length == 0) {
            this.tail = null;
        }
        return temp;
    }

    public Node removeLast() {
        //traverse the linkedList until next = null
        //reposition tail
        //keep track of prev and temp nodes
        Node prev = this.head;
        Node temp = this.head;
        if(this.length == 0) {
            return null;
        } else {
            while(temp.next != null) {
                prev = temp;
                temp = temp.next;
            }

            this.tail = prev;
            this.tail.next = null;

            this.length--;
            if(this.length == 0) {
                this.head = null;
                this.tail = null;
            }
            return temp;
        }
    }

    public Node getHead() {
        System.out.println("Head "+this.head.value);
        return this.head;
    }

    public Node getTail() {
        System.out.println("Tail "+this.tail.value);
        return this.tail;
    }

    public int getLength() {
        return this.length;
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
        //return super.toString();
    }
}
