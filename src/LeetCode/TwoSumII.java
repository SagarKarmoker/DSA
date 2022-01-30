package LeetCode;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(twoSum(arr, 2)));
    }

    static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == numbers[mid]) {
                return new int[]{mid};
            } else if (target > numbers[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
