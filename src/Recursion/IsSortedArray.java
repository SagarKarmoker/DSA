package Recursion;

public class IsSortedArray {

    public static boolean isSorted(int[] arr, int size) {
        if (size == 0 || size == 1) {
            return true;
        }
        if (arr[0] > arr[1]) {
            return false;
        } else {
            //return isSorted(arr+1, size - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {40, 60, 1, 200, 9, 83, 17};
        int size = arr.length;

        if (isSorted(arr, size))
        {
            System.out.println("Array is sorted");
        }
        else
        {
            System.out.println("Array is not sorted");
        }
    }
}
