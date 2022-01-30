package DSTopic.Searching;

public class LinearSearch {
    public static int search(int array[], int key, int size) {
        for (int i = 0; i < size; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {12, 24, 235, 100, 99};
        int size = arr.length;
        int key = 24;

        //System.out.println(search(arr, key, size));

        //using the only for loop
        for (int i = 0; i < size; i++) {
            if (key == arr[i]) {
                System.out.println("Found at = " + i);
                break;
            }
        }

    }
}
