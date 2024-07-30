package algorithms.sorting.quicksort;


import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    Set<Integer> mySet = new HashSet<>();
    //[0, 2, 4, 0, 0, 0]
    //[0]
    public void test() {
        mySet.add(2);
        mySet.stream().mapToInt(i -> i).boxed().toArray();

    }
}
