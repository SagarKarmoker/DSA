package LeetCode;

//https://leetcode.com/problems/guess-number-higher-or-lower/

public class GuessNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNum(n));
    }

    static int guessNum(int n){
        int low = 1;
        int high = n;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int num = guess(mid);

            if(num == 0){
                return mid;
            }
            else if (num == 1)
            {
                low = mid + 1;
            }else
            {
                high = mid - 1;
            }
        }

        return 0;
    }

    static int guess(int mid) {
        int pick = 6;

        if(pick == mid){
            return 0;
        }
        else if(pick > mid){
            return 1;
        }
        else {
            return -1;
        }
    }
}
