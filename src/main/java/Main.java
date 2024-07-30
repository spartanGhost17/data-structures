import algorithms.sorting.bubblesort.BubbleSort;
import algorithms.sorting.insertionsort.InsertionSort;
import algorithms.sorting.mergesort.MergeSort;
import algorithms.sorting.selectionsort.SelectionSort;
import dataStructures.Heap.Heap;
import dataStructures.binarysearchtree.BinarySearchTree;
import dataStructures.doublyLinkedList.DoublyLinkedList;
import dataStructures.graph.Graph;
import dataStructures.hashtable.HashTable;
import dataStructures.linkedlist.LinkedList;
import dataStructures.queue.Queue;
import dataStructures.stack.Stack;

import java.util.*;
import java.util.stream.Collectors;


//import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> s = new HashMap<>();

        //s.values().stream().sorted().collect(Collectors.toList())
        doBinarySearch();
        doFindDuplicate();
        doMergeSortedArrays();
        doMergeSort();
        doFindSumOfTwoSorted();
        doFindSumOfTwoUnsorted();

        doAnagram_n_mLogM();
        doAnagramGroups_n_times_M();
        doSubArraySum();
        doFindPairsSum();
        doLongestConsecutiveSequence();
        doMinMaxSum();
        doMergeOverlapIntervals();

        doLinkedList();
        doDoublyLinkedList();
        doStack();
        doQueue();
        doBinarySearchTree();
        doHashTable();
        doGraph();
        doHeap();

        doSorting();


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());



        //minHeap.iterator(); [5, 4, 3, 2, 1] maxHeap removal |:| [1, 2, 3, 4, 5] minHeap removal
        //Collections.sort(new ArrayList<Integer>(), Comparator.reverseOrder());
        //Arrays.sort(new int[] {3, 2, 1, 5});

        /**
         * list to array
         * and array to list conversion
         *
         * and sorting asc && desc
         */
        int[] tArr = new int[] {2, 4, 1, 3, 5};

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        Integer[] toarr = new Integer[l.size()];
        toarr = l.toArray(toarr);

        int[] toarr2 = l.stream().mapToInt(i -> i).toArray();
        List<Integer> arrL =  Arrays.stream(tArr).boxed().collect(Collectors.toList());

        //custom comparator
        Comparator<Integer> comparator = (a1, a2) -> Integer.compare(a1, a2);

        //reversed order
        Collections.sort(arrL, comparator.reversed());

        //ascending order
        Collections.sort(arrL, comparator);

        //primitive types ascending and descending
        Collections.sort(arrL, Comparator.naturalOrder());
        Collections.sort(arrL, Comparator.reverseOrder());

        Arrays.sort(tArr);
        //System.out.println("reversed order sort "+arrL);
        //Collections.sort(Arrays.asList(t), Comparator.naturalOrder());
        //Arrays.sort(t, Comparator.comparingInt());

        //System.out.println("Math.pow "+ Math.pow(6, 10000));

        System.out.println(isValidCreditCardNumber("4532015112830366"));
    }


    public static boolean isValidCreditCardNumber(String cardNumber) {
        int sum = 0;
        boolean doubleDigit = false;

        // Iterate over the card number digits from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            // Get the current digit
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (doubleDigit) {
                // Double the digit
                digit *= 2;

                // If the result is greater than 9, sum the digits
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }

            // Add the digit to the sum
            sum += digit;

            // Toggle the doubleDigit flag
            doubleDigit = !doubleDigit;
        }

        // Check if the sum's last digit is 0
        return sum % 10 == 0;
    }

    public int firstUniqChar(String s) {
        //Input: s = "leetcode"
        //Output: 0
        int num = -1;
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int first = 0;
        for(int i = 0; i < s.length(); i++) {
            if(first < 1 && (freq[s.charAt(i) - 'a'] == 1)) {
                System.out.println(s.charAt(i)+" triple "+freq[s.charAt(i) - 'a']);
                num = i;
                first++;
            }
        }
        System.out.println("");
        return num;
    }
    public static void doSorting() {
        System.out.println();
        int[] array1Bsort = {2, 5, 3, 1, 6, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array1Bsort);

        int[] array2SelectSort = {1, 5, 3, 2, 6, 4};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array2SelectSort);

        int[] array3InsertSort = {4, 2, 6, 5, 1, 3};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array3InsertSort);//O(n^2) worst case almost sorted O(n)

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] toMergeSort = {3, 1, 5, 2, 4};
        MergeSort mergeSort = new MergeSort();
        int[] merge = mergeSort.merge(arr1, arr2);
        int[] mergeSorted = mergeSort.mergeSort(toMergeSort);

        System.out.println("Bubble sort array [2, 5, 3, 1, 6, 4] after sorting: "+Arrays.toString(array1Bsort));
        System.out.println("Selection sort array [1, 5, 3, 2, 6, 4] after sorting: "+Arrays.toString(array2SelectSort));
        System.out.println("Insertion sort array [4, 2, 6, 5, 1, 3] after sorting: "+Arrays.toString(array3InsertSort));
        System.out.println("Merge two array in ascending order arr1: {1, 3, 5} arr2: {2, 4, 6} results: "+Arrays.toString(merge));
        System.out.println("Merge sort array {3, 1, 5, 2, 4} results "+Arrays.toString(mergeSorted));

        //String s = "ayt";
        //s.charAt(0);
        //System.out.println("Character at 1 "+s.charAt(1));
    }
    public static void doHeap() {
        Heap heap = new Heap();
        heap.insert(95);
        heap.insert(75);
        heap.insert(80);
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);
        heap.remove();
        System.out.println("[Heap printed] "+heap.toString());
    }
    public static void doGraph() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        //graph.removeEdge("A", "C");
        graph.removeVertex("C");
        System.out.println("Graph "+graph.toString());
    }
    public static void doHashTable() {
        HashTable hashTable = new HashTable();
        hashTable.set("nails", 100);
        hashTable.set("title", 50);
        hashTable.set("lumber", 80);
        hashTable.set("bolts", 200);
        hashTable.set("screws", 140);

        System.out.println("HashTable "+hashTable.toString());
        System.out.println("Get all keys HashTable "+hashTable.keys().toString());
        System.out.println("Get bolts count in HashTable "+hashTable.get("bolts"));
        System.out.println("");
    }
    public static void doBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.rInsert(47);
        tree.rInsert(21);
        tree.rInsert(76);
        tree.rInsert(18);
        tree.rInsert(52);
        tree.rInsert(82);
        //[47, 21, 76, 18, null, 52, 82]

        //tree.insert(27);

        System.out.println("BinarySearchTree Printed ");//+tree.getRoot().left.right.value);
        System.out.println("BST Contains value 27? "+tree.contains(27));
        System.out.println("BST recursive Contains value 18? "+tree.rContains(18));

        System.out.println("BST print using BFS (Breath first search) "+tree.BFS());

        System.out.println("DFS print using DFS Pre-Order recursive "+tree.DFSPreOrder2());
        System.out.println("DFS print using DFS Pre-Order recursive <[class]> "+tree.DFSPreOrder());

        System.out.println("DFS print using DFS Post-Order recursive "+tree.DFSPostOrder2());
        System.out.println("DFS print using DFS Post-Order recursive <[class]> "+tree.DFSPostOrder());

        System.out.println("DFS print using DFS In-Order recursive "+tree.DFSInOrder2());
        System.out.println("DFS print using DFS In-Order recursive <[class]> "+tree.DFSInOrder());

        System.out.println("");
    }

    public static void doQueue() {
        Queue queue = new Queue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        System.out.println("Queue printed "+ queue.toString());
        System.out.println("");
    }

    public static void doStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(0);
        stack.pop();
        stack.sortStack(stack);
        System.out.println("Stack printed "+ stack.toString());
        System.out.println("");
    }
    public static void doDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);
        doublyLinkedList.append(6);
        doublyLinkedList.append(5);
        doublyLinkedList.append(4);
        doublyLinkedList.removeLast();
        doublyLinkedList.prepend(8);
        doublyLinkedList.removeFirst();
        doublyLinkedList.insert(1, 10);
        doublyLinkedList.remove(1);
        System.out.println("Node in DoublyLinkedList at index of (1): "+doublyLinkedList.get(1).getValue());
        System.out.println("DoublyLinkedList printed  "+doublyLinkedList.toString());
        System.out.println("");
    }
    public static void doLinkedList() {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.removeLast();
        linkedList.prepend(2);
        linkedList.removeFirst();
        linkedList.insert(1, 10);
        linkedList.reverse();
        //linkedList.partitionList(10);
        System.out.println("LinkedList printed  "+linkedList.toString());
        linkedList.partitionList(10);
        System.out.println("LinkedList after partitioning printed  "+linkedList.toString());
        System.out.println("");
    }
    /**
     * merge and sort unsorted lists
     */
    public static void doMergeSort() {
        int[] unsorted = {3, 1, 4, 3, 2};
        int[] sorted = mergeSort(unsorted);
        System.out.println("Unsorted array to Merge sorted array "+ Arrays.toString(sorted));
        System.out.println("");
    }

    public static int[] mergeSort(int[] array) {
        if(array.length == 1) return array;

        int midIndex = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return mergeSortedArrays(left, right);
    }

    /**
     * for a sorted array
     */
    public static void doMergeSortedArrays() {
        int[] arr1 = {0, 3, 4, 31};
        int[] arr2 = {4, 6, 30};
        int[] mergeSortedList = mergeSortedArrays(arr1, arr2);//mergeSortedArrays(Arrays.asList(0, 3, 4, 31), Arrays.asList(4, 6, 30));
        System.out.println("Sorted lists to merge sorted list "+Arrays.toString(mergeSortedList));
        System.out.println("");
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        //List<Integer> mergedArray = new ArrayList<>();
        int[] mergedArray = new int[arr1.length + arr2.length];
        int idx = 0;
        int idx2 = 0;
        int mergeIdx = 0;
        if(arr1.length == 0) {
            return arr2;
        }

        if(arr2.length == 0) {
            return arr1;
        }

        //
        while (idx < arr1.length && idx2 < arr2.length) {
            int arr1Item = arr1[idx];
            int arr2Item = arr2[idx2];
            if(arr1Item < arr2Item) {
                mergedArray[mergeIdx] = arr1Item;
                idx++;
            } else {
                mergedArray[mergeIdx] = arr2Item;
                idx2++;
            }
            mergeIdx++;
        }

        while(idx < arr1.length) {
            mergedArray[mergeIdx] = arr1[idx];
            idx++;
        }

        while(idx2 < arr2.length) {
            mergedArray[mergeIdx] = arr2[idx2];
            idx2++;
        }

        return mergedArray;
    }
    public static void doFindDuplicate(){
        Character[] char1 = {'a', 'b', 'c', 'r'};
        Character[] char2 = {'z', 'y', 'w', 'a'};
        System.out.println("Does character duplicate exists?  "+ findDuplicate(char1, char2));
        System.out.println("");
    }

    /**
     *
     */
    public static void doFindSumOfTwoUnsorted() {
        int [] array = {1, 3, 2, 5, 7};
        int target = 7;
        System.out.println("Find sum of two for unsorted list "+Arrays.toString(findSumOfTwoUnsorted(array, target)));
        System.out.println("");
    }

    public static int[] findSumOfTwoUnsorted(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(complements.containsKey(complement)) {
                return new int[]{complements.get(complement), i};
            }
            complements.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * find pairs of sum
     */
    public static void doFindPairsSum() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        System.out.println("Find pairs sum in between these two arrays arr1: {1, 2, 3, 4, 5}  arr2: {2, 4, 6, 8, 10} target: 7 ");
        pairs.stream().forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("");
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> mySet = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : arr1) {
            mySet.add(num);
        }

        for (int num : arr2) {
            int complement = target - num;
            if (mySet.contains(complement)) {
                pairs.add(new int[]{complement, num});
            }
        }

        return pairs;
    }

    public static void doLongestConsecutiveSequence() {
        int seq1 = longestConsecutiveSequence( new int[] {1, 3, 5, 7, 9});
        int seq2 = longestConsecutiveSequence(new int[] {1, 2, 2, 3, 4});
        int seq3 = longestConsecutiveSequence(new int[] {1, 0, -1, -2, -3});
        System.out.println("Longest sequence for NO Duplicates {1, 3, 5, 7, 9} len: "+seq1);
        System.out.println("Longest sequence for Duplicates {1, 2, 2, 3, 4} len: "+seq2);
        System.out.println("Longest sequence for Negative Numbers {1, 0, -1, -2, -3}  len: "+seq3);
        System.out.println("");
    }

    /**
     * the start of a sequence is a value x for which (x - 1) does not exist in the value set
     * @param nums
     * @return
     */
    public static int longestConsecutiveSequence(int[] nums) {
        int count = 0;
        //get rid of duplicates
        //100, 4, 200, 1, 3, 2 -> [1] [1, 2, 3, 4] [100] [200]
        // x - 1 !exist
        //  loop until x exist?
        //      x++;
        //      currLen++
        //max(ogLen, currLen)
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {//O(n)
            set.add(n);
        }

        for(int n : set) {
            int seqLength = 0;
            int x = n;
            if(!set.contains(n - 1)) {
                while(set.contains(x)) {
                    seqLength++;
                    x++;
                }
            }
            count = Math.max(count, seqLength);
        }
        //set -> map -> O(1)
        //O(n)
        return count;
    }

    /**
     * doSubArraySum
     */
    public static void doSubArraySum() {
        int[] nums1 = {1, 2, 3, 4, 5};//[1, 3]
        int target1 = 9;
        int[] result1 = subArraySum(nums1, target1);
        System.out.println("Sub Array sum of [1, 2, 3, 4, 5] and target = 9 is [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};//[0, 3]
        int target2 = 0;
        int[] result2 = subArraySum(nums2, target2);
        System.out.println("Sub Array sum of [-1, 2, 3, -4, 5] and target = 0 is [" + result2[0] + ", " + result2[1] + "]");
    }

    /**
     * find the sub array sum within an array
     * steps
     * 1) keep track of the sum
     * 2) save the numbers seen in a map {num: index}
     * 3) check if abs(sum) > abs(target)
     * 4) if yes do key = sum - 1 to get index in map. then do key.value + 1 to get the start of the sub array
     * 5) if sum == target -> then all numbers add up to sum up to the end index
     * @param nums
     * @param target
     * @return
     */
    public static int[] subArraySum(int[] nums, int target) {
        /*int start = 0, end = 0, sum = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            end = i;
            seen.put(nums[i], i);
            if(Math.abs(sum) > Math.abs(target)) {
                int diff = sum - target;
                start = seen.get(diff) + 1;
                return new int[] {start, end};
            }
            else if(sum == target) {
                start = 0;
                return new int[] {start, end};
            }
        }
        return new int[]{};*/
        //second approach
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};
    }

    /**
     * sum of two in sorted array
     */
    public static void doFindSumOfTwoSorted() {
        int [] array = {1, 2, 3, 4};
        int target = 5;
        System.out.println("Find sum of two for sorted list "+Arrays.toString(findSumOfTwoSorted(array, target)));
    }

    public static int[] findSumOfTwoSorted(int[] nums, int target) {
        // Initialize two pointers, one at the beginning and one at the end
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    public static boolean findDuplicate(Character[] char1, Character[] char2) {
        List<Character> iterator = new ArrayList<>();
        List<Character> iterator2 = new ArrayList<>();
        if(char1.length == 0 || char2.length == 0) {
            return false;
        }

        if(char1.length >= char2.length) {
            iterator = Arrays.asList(char1);
        }
        if(char2.length <= char1.length){
            iterator2 =  Arrays.asList(char2);
        }

        //method 1 O(n + n) => O(2n) => O(n)
        Map<Character, Integer> count = new HashMap<>();
        for(Character c : iterator2) {
            count.put(c, 1);
        }

        for(Character c : iterator) {
            if(count.get(c) != null) {
                return true;
            }
        }

        //or method 2 O(n^2)
        /*for(Character c : iterator2) {
            if(iterator.contains(c)) {
                return true;
            }
        }*/
        return false;
    }

    /**
     * binary search
     */
    public static void doBinarySearch() {
        // Example array (must be sorted)
        int[] array = {1, 1, 3, 5, 7, 9, 11, 13, 15};

        // Element to search for
        int target = 7;

        // Perform binary search
        int index = binarySearch(array, target);

        // Print result
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            //target > array[mid] -> left = mid + 1;
            else if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // If we reach here, then the element was not present
        return -1;
    }

    /**
     * find anagrams in O(n * m log m)
     * by using sorting of string
     */
    public static void doAnagram_n_mLogM() {
        String[] anagrams = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Anagrams groups O(n * m log m)"+groupAnagrams1(anagrams));
    }

    public static List<List<String>> groupAnagrams1(String[] strings) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String s : strings) { //O(n)
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray); //O(m log m)
            String sortedS = new String(cArray);
            if(!anagrams.containsKey(sortedS)) {
                anagrams.put(sortedS, new ArrayList<>());
            }
            anagrams.get(sortedS).add(s);
        }
        //O(n * m log m)
        // Convert Map values to List<List<String>>
        List<List<String>> result = new ArrayList<>(anagrams.values());
        return result;
    }

    public static void doAnagramGroups_n_times_M() {
        String[] anagrams = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Anagrams groups O(n * m) "+groupAnagrams2(anagrams));
    }

    public static List<List<String>> groupAnagrams2(String[] strings) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String s : strings) { //O(n)
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < count.length; i++) {
                if(count[i] > 0) {
                    //String.valueOf('a');
                    sb.append('a' + i).append(count[i]);
                }
            }

            String freqStr = sb.toString();

            if(!anagrams.containsKey(freqStr)) {
                anagrams.put(freqStr, new ArrayList<>());
            }
            anagrams.get(freqStr).add(s);
        }
        //O(n * m log m)
        // Convert Map values to List<List<String>>
        List<List<String>> result = new ArrayList<>(anagrams.values());
        return result;
    }

    /**
     * find min and max sum need to take the total sum of array
     * min sum = total sum - max number
     * max sum = total sum - min number
     */
    public static void doMinMaxSum() {
        int[] numbers = {1, 2, 3, 4, 5};
        List<Integer> num = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        int[] result = miniMaxSum(num);
        System.out.println("Min max sum of array {1, 2, 3, 4, 5} ["+ result[0] + "," + result[1]+"]");
    }
    public static int[] miniMaxSum(List<Integer> arr) {
        Integer minSum = Integer.MAX_VALUE;
        Integer maxSum = Integer.MIN_VALUE;
        Integer totalSum = 0;
        Collections.sort(arr);
        // Calculate total sum and find min/max elements
        for (int num : arr) {
            totalSum += num;
            minSum = Math.min(minSum, num);
            maxSum = Math.max(maxSum, num);
        }

        Integer minPossibleSum = totalSum - maxSum;
        Integer maxPossibleSum = totalSum - minSum;
        //System.out.println(minPossibleSum+" "+maxPossibleSum);
        return new int[] {minPossibleSum, maxPossibleSum};
    }

    //needs to be sorted first
    public static void doMergeOverlapIntervals() {
        int[][] nums = new int[][] {{1, 4}, {3, 6}, {7, 9}, {8, 10}};
        int[][] intervals = mergeOverlapIntervals(nums);

        System.out.print("Merge Overlapping Intervals {{1, 4}, {3, 6}, {7, 9}, {8, 10}} ");
        Arrays.stream(intervals).forEach(arr -> System.out.print(" "+Arrays.toString(arr)+","));
        System.out.println("\n");
    }

    public static int[][] mergeOverlapIntervals(int[][] nums) {
        if(nums.length <= 1) return nums;
        //Arrays.sort(nums, Comparator.comparingInt(arr -> arr[0]));
        Arrays.sort(nums, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> res = new ArrayList<>();
        int[] currentInterval = nums[0];
        res.add(currentInterval);

        for(int[] interval : nums) {
            int currBegin = currentInterval[0];
            int currEnd = currentInterval[1];

            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if(currBegin >= nextBegin) {
                currentInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currentInterval = interval;
                res.add(currentInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
































}
