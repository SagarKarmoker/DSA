package BinarySearch;

/**
 * Sorted matrix of Binary Search
 * 4*4 matrix
 */

import java.util.Arrays;

public class BinaryMatrix {
    public static void main(String[] args) {
        int[][] array = {
                {10, 20 ,30 ,40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int key = 29;
        System.out.println(Arrays.toString(search(array, key)));
    }

    static int[] search(int[][] matrix, int key){
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                return new int[]{row, col};
            }
            if(matrix[row][col] < key){
                row++;
            }
            else {
                col--;
            }
        }

        return new int[]{-1, -1};
    }
}
