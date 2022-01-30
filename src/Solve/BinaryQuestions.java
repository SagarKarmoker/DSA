package Solve;

import java.util.*;

public class BinaryQuestions {

    public static int[] find(int[] arr, int key){
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        int[] idx = new int[arr.length];
        int i = 0;

        while (low <= high){
            int mid = (low + high) /2;
            if(key == arr[mid]){
                idx[i] = mid;
            }
            else if(key > arr[mid]){
                low = mid +1;
            }
            else {
                high = mid - 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,2,3};
        int key = 2;
        System.out.println(Arrays.toString(find(arr, key)));
    }
}
