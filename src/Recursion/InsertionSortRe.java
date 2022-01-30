package Recursion;

public class InsertionSortRe {

    public static void sort(int[] arr, int size){
        // base case
        if(size == 0 || size == 1){
            return;
        }

        int j, key;
        sort(arr, size-1);
        //System.out.println(Arrays.toString(arr));
        key = arr[size-1]; // storing key to update this later
        j = size - 2;
        //System.out.println("Key = " + key + " and j = " + j);
        while (j >= 0 && arr[j] > key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key; // updated here means swap
    }


    public static void main(String[] args) {
        int[] arr = {12,4,9,2,1,0,11};
        int size = arr.length;

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sort(arr, size);
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
