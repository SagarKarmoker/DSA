package DSTopic.Searching;

public class BinarySearch {
    public static int search(int arr[], int size, int key) {
        int low = 0, high = (size - 1), mid;
        while (low <= high) {   // low is always lower than high
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] < key) { // key > arr[mid]
                low = mid + 1;
            }
            else {  // key < arr[mid]
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 8, 9};
        int size = (arr.length - 1);

        int mid = search(arr, size, 6);

        if (mid == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at " + mid);
        }
    }
}
