package AlgolrithmSort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,1,7,2,2,25,12,463,-2,-45,63,3};
        bubbleSort(arr);
        for (int i: arr){
            System.out.print(i+" ");
        }
    }

    public static void bubbleSort(int[] array){
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
