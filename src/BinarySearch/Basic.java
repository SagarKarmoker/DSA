package BinarySearch;

public class Basic {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 8, 12, 34};
        int target = 3;
        System.out.println(binarySearch(array, target));
    }

    static int binarySearch(int[] array, int target){
        int start = 0; // index number
        int end = array.length - 1; // index number

        while (start <= end){
            //int mid = (start + end) / 2;
            //Better way to find mid
            int mid = start + (end - start) / 2;

            if(target < array[mid]){  // if target element is less than mid element value
                end = mid - 1;          // end the will be mid-1
            }else if(target > array[mid]){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        // if the element not found in the array
        return -1;
    }


}
