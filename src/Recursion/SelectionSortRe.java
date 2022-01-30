package Recursion;

public class SelectionSortRe {

    public static void sort(int[] arr, int size){
        // base case
        if(size == 0 || size == 1){
            return;
        }

        //process
        int min;
        for(int i = 0; i < size-1; i++){
            min = i;
            for(int j = i + 1; j < size; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp;
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
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
