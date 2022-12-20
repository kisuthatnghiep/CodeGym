package AlgolrithmSort;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 1, 6, 7, 3, -9, 46, 16, 7, 9, 2, 6, 4};
        insertionSort(array);
        for (int i : array) {
            System.out.print(i + ", ");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && temp < array[j]; j--){
                array[j + 1] = array[j];
            }
            array[j+1] = temp;
        }
    }
}