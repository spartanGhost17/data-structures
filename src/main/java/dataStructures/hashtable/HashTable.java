package dataStructures.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        private String key;
        private int value;
        private Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.dataMap = new Node[this.size];
    }

    public List<String> keys() {
        List<String> allKeys = new ArrayList<>();
        for(int i = 0; i < this.dataMap.length; i++) {
            Node temp = this.dataMap[i];
            while(temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = this.dataMap[index];
        while(temp != null) {
            if(temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node node = new Node(key, value);
        if(dataMap[index] == null) {
            dataMap[index] = node;
        } else {
            Node temp = dataMap[index];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            //multiply by a prime number (23 here) to get a more random number
            hash = ( hash + asciiValue * 23 ) % dataMap.length;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.dataMap.length; i++) {
            //System.out.println(i + ":");
            sb.append(" "+i + ":");
            Node temp = this.dataMap[i];
            if(temp == null) {
                sb.append(" {} ");
            }
            while(temp != null) {
                //System.out.println(" {" +temp.key + "= "+ temp.value + "}");
                sb.append(" {" +temp.key + "= "+ temp.value + "}");
                temp = temp.next;
            }
        }
        return sb.toString();
    }
}
