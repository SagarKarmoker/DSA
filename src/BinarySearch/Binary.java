package BinarySearch;

public class Binary {
    public static void main(String[] args) {
        int[] arr = {-2, -3, -4, -15, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        //int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int key = 0;

        System.out.println(bSearch(arr, key));
    }

    static int bSearch(int[] array, int key){

        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if(array[mid] == key){
                return mid;
            }else if(key > array[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        // if the element not found in the array
        return -1;
    }
}
