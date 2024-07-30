package algorithms.sorting.insertionsort;

public class InsertionSort {


    public void insertionSort(int[] array) { //O(n^2) worst case
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while(j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}
