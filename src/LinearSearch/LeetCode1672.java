package LinearSearch;
//https://leetcode.com/problems/richest-customer-wealth/

public class LeetCode1672 {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3}, {3,2,1}};

        System.out.println(maximumWealth(accounts));
    }

    static int maximumWealth(int[][] accounts){
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }

            if(sum > ans){
                ans = sum;
            }
        }

        return ans;
    }

}
