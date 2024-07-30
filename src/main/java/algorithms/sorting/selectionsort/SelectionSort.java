package algorithms.sorting.selectionsort;

public class SelectionSort {
    //[6, 1, 4, 5, 3, 2]
    //0
    public void selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //swap
            if(i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
