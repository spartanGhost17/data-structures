package dataStructures.stack;

public class Stack<T extends Comparable> {
    private Node top;
    private int height;

    class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    public Stack() {}
    public Stack(T value) {
        Node node = new Node(value);
        this.top = node;
        this.height = 1;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public Node peek() {
        if (isEmpty()) {
            return null;
        } else {
            return this.top;//stackList.get(stackList.size() - 1);
        }
    }

    public void sortStack(Stack<Integer> originalStack) {
        if(originalStack.isEmpty()) return;
        Stack<Integer> descStack = new Stack<>();

        while(!originalStack.isEmpty()) {
            int top = originalStack.pop().value;
            //if(descStack.isEmpty()) {
            //    descStack.push(top);
            //} else {
            while(!descStack.isEmpty() && top < descStack.peek().value) {
                int descTop = descStack.pop().value;
                originalStack.push(descTop);
            }
            descStack.push(top);
            //}
        }

        while(!descStack.isEmpty()) {
            int top = descStack.pop().value;
            originalStack.push(top);
        }
    }

    public Node pop() {
        if(this.top == null) return null;
        Node temp = this.top;
        this.top = temp.next;
        temp.next = null;
        this.height--;
        return temp;
    }
    public void push(T value) {
        Node node = new Node(value);
        if(this.height > 0) {
            node.next = this.top;
        }
        this.top = node;
        /*if(this.height == 0) {
            this.top = node;
        } else {
            node.next = this.top;
            this.top = node;
        }*/
        this.height++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node iterator = this.top;
        while(iterator != null) {
            sb.append(" N["+iterator.value+"] ");
            iterator = iterator.next;
        }
        return sb.toString();
    }
}
