package LinearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] array = {
                {1, 34, -56, -7},     //0
                {12, 33, 819, 22},   //1
                {21, 54, 23, 45},   //2
                {154, 76, 58, 84},  //3
        };

        int target = 154;

        // getting index of element in row and col
        int[] index = search(array, target);
        System.out.println( "{row, col} = " + Arrays.toString(index));

        // searching max value of 2D array
        System.out.println(searchMAX(array));

        // searching min value of 2D array
        System.out.println(searchMIN(array));

    }

    static int[] search(int[][] array, int target) {

        if(array.length == 0){
            return new int[]{-1, -1}; // creating new array object because the array is not initialized
        }

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if(array[row][col] == target){
                    return new int[]{row, col}; // new int[] {row, col} creating new array object because the array is not initialized
                }
            }
        }
        return new int[]{-1, -1}; // creating new array object because the array is not initialized
    }

    // Maximum Value of the 2D array
    static int searchMAX(int[][] array) {

        int max = Integer.MIN_VALUE;

        if(array.length == 0){
            return -1;
        }

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if(array[row][col] > max){
                   max = array[row][col];
                }
            }
        }
        return max;
    }

    // Minimum Value of the 2D array
    static int searchMIN(int[][] array) {

        int min = Integer.MAX_VALUE;

        if(array.length == 0){
            return -1;
        }

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if(array[row][col] < min){
                    min = array[row][col];
                }
            }
        }
        return min;
    }


}
