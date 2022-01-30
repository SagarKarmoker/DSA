package Sorting;

import java.util.Arrays;

public class InsertionSortAlgo {
    public static int[] sort(int[] arr, int n){
        int i, j, key;
        for(i = 1; i < n; i++){
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 25, 12, 22, 64};
        int size = arr.length;
        System.out.println(Arrays.toString(arr));
        // after sorting
        System.out.println(Arrays.toString(sort(arr, size)));
    }
}
