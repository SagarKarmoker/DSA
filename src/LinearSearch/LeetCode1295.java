package LinearSearch;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/


public class LeetCode1295 {
    public static void main(String[] args) {
        int[] array = {12, 2 , 2224, 2, 93};
        int ans = findNumbers(array);
        System.out.println(ans);
    }

    static int findNumbers(int[] nums) {
        int count = 0;

        for(int n : nums){
            if(even(n) % 2 == 0){
                count++;
            }
        }

        return count;
    }

    static int even(int n) {
        String s = String.valueOf(n);
        return s.length();
    }
}
