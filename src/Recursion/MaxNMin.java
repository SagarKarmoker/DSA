package Recursion;

import java.util.Arrays;

public class MaxNMin {
    public static int minNmax(int[] arr, int size){
        // base case
        if(size == 1){
            return arr[0];
        }
        System.out.println(Arrays.toString(arr));
        return Math.min(arr[size-1], minNmax(arr, size-1)); // for min
        //return Math.max(arr[size-1], minNmax(arr, size-1)); // for max
    }
    public static void main(String[] args) {
        int[] arr = {-5 ,1, -20, 3, 4, 5, 10};
        int size = arr.length;
        System.out.println(minNmax(arr, size));
    }
}
