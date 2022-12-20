package AlgolrithmSearch;

import AlgolrithmSort.InsertSort;

public class BinarySearchDeQuy {
        public static void main(String[] args) {
            int[] array1 = {5, 1, 6, 7, 3, -9, 46, 16, 7, 9, 2, 6, 4};
            InsertSort.insertionSort(array1);
            for (int i : array1) {
                System.out.print(i + ", ");
            }
            System.out.println();
            System.out.println(binarySearch1(array1, 7,0, 1));

        }
        static int binarySearch1(int[] array, int key, int a, int b){
            int mid = (a + b) / 2;
            if (a != b){
            if(key > array[mid]){
                    a = mid + 1;
                    return binarySearch1(array,key,a,b);
                } else{
                    b = mid - 1;
                    return binarySearch1(array,key,a,b);
                }
            }else {
                if (key == array[mid]){
                    return mid;
                }else {
                    return -1;
                }
            }
            }
        }

