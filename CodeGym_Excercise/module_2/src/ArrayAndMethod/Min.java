package ArrayAndMethod;

import ModifierAndStatic.AccessModifier;

public class Min {
    public static void main(String[] args) {
    int[] arr ={1,2,4,5,7,2,3,-3};
        System.out.println("The smallest value in the array is: "+minValue(arr));
    }
    public static int minValue(int[] array){
        int min = 0;
        for(int i:array){
            if (min > i)
                min = i;
        }
        return min;
    }
}