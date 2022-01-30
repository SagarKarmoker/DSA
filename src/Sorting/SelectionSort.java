package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {

        int temp, min;
        int size = arr.length;

        for (int i = 0; i < (size - 1); i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {   // forwarding 1 step more
                if (arr[j] < arr[min]) {    // checking if min is greater or less than the number
                    min = j;
                }
            }
            // swapping the numbers
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {11, 25, 12, 22, 64};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
