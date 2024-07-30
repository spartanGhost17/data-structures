package dataStructures.Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(this.heap);
    }

    //insert from the right most
    public void insert(int value) {
        this.heap.add(value);
        int current = this.heap.size() - 1;
        while(current > 0 && this.heap.get(current) > this.heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if(this.heap.size() == 0) return null;
        if(this.heap.size() == 1) {
            return this.heap.remove(0);
        }
        int maxValue = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() -1));
        sinkDown(0);

        return maxValue;
    }

    public void sinkDown(int index) {
        int maxIndex = index;
        while(true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < this.heap.size() && this.heap.get(leftIndex) > this.heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if(rightIndex < this.heap.size() && this.heap.get(rightIndex) > this.heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if(maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }

        }
    }

    public int leftChild(int index) {
        return 2 * index + 1;//2 * index in heap starting from 1
    }

    public int rightChild(int index) {
        return 2 * index + 2;// 2 * index + 1 in heap starting from 1
    }

    public int parent(int index) {
        return (index - 1) / 2;// index / 2 in heap starting from 1
    }

    public void swap(int index1, int index2) {
        int temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }

    @Override
    public String toString() {
        return this.heap.toString();
    }
}
