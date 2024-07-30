package algorithms.sorting.mergesort;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] array) {
        //[3, 1, 5, 2, 4] :-> L: [3, 1] ~ R: [5, 2, 4]
        //L: [3] ~ R: [1] //L: [5, 2] ~ R: [4] // L: [5] R: [2]

        //rL1: [1, 3] //rR2 [2, 5] //rR1 [2, 4, 5] //
        //rL0: [1, 3] rR0 [2, 4, 5] -> [1, 2, 3, 4, 5]
        if(array.length == 1) return array;
        int midPoint = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midPoint));
        int[] right = mergeSort(Arrays.copyOfRange(array, midPoint, array.length));
        return merge(left, right);
    }
    public int[] merge(int[] array1, int[] array2) {
        int[] mergeArray = new int[array1.length + array2.length];
        int arr1Ptr = 0;
        int arr2Ptr = 0;
        int mergePtr = 0;
        //[1, 3, 5] [2, 4]
        //       ^        ^
        //[1, 2, 3, 4]
        if(array1.length == 0) return array2;
        if(array2.length == 0) return array1;

        while(arr1Ptr < array1.length && arr2Ptr < array2.length) {
            if(array1[arr1Ptr] < array2[arr2Ptr]) {
                mergeArray[mergePtr] = array1[arr1Ptr];
                mergePtr++;
                arr1Ptr++;
            } else {
                mergeArray[mergePtr] = array2[arr2Ptr];
                mergePtr++;
                arr2Ptr++;
            }
        }

        while(arr1Ptr < array1.length) {
            mergeArray[mergePtr] = array1[arr1Ptr];
            mergePtr++;
            arr1Ptr++;
        }

        while(arr2Ptr < array2.length) {
            mergeArray[mergePtr] = array2[arr2Ptr];
            mergePtr++;
            arr2Ptr++;
        }

        return mergeArray;
    }
}
