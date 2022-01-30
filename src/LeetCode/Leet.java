package LeetCode;

import java.util.Arrays;

public class Leet {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }

    static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            low = mid + 1;
            while (low <= high) {

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

        return new int[]{-1, -1};
    }
}
