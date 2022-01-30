package BinarySearch;

/**
 * This is an incomplete code
 */
public class BinaryRecursion {
    public static void main(String[] args) {
        int[] arr = {-2, -3, -4, -15, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        //int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int key = 15;

        System.out.println(bSearch(arr, key, 0, arr.length-1));
    }

    static int bSearch(int[] array, int key, int low, int high){

        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;

        if(array[mid] == key){
            return mid;
        }
        if(key > array[mid]){
            bSearch(array, key, (mid + 1), high);
        }
        return bSearch(array,key, low, mid - 1);
    }
}
