package AlgolrithmSearch;

import AlgolrithmSort.InsertSort;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {5, 1, 6, 7, 3, -9, 46, 16, 7, 9, 2, 6, 4};
        InsertSort.insertionSort(array);
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(binarySearch(array, 7));

    }
    static int binarySearch(int[] array, int key){
        int first = 0;
        int last = array.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (key < array[mid]) {
                last = mid - 1;
            } else if (key > array[mid]) {
                first = mid + 1;
            } else return mid;
        }
        return -1;
    }
}
