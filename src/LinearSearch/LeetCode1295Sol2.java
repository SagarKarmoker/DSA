package LinearSearch;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class LeetCode1295Sol2 {
    public static void main(String[] args) {
        // array
        int[] array = {12, 2 , 2224, 2, 93};

        System.out.println(findNumbers(array));

        System.out.println(digits(0));

        System.out.println(digits2(0));
        System.out.println(digits2(115));


        System.out.println(digits(-646));
        System.out.println(digits2(54154));
    }

    // counting total number that of even digits
    static int findNumbers(int[] nums){
        int count = 0;
        for(int n: nums){
            if(even(n)){
                count++;
            }
        }
        return count;
    }

    // checking the num is even or not
    static boolean even(int num){
        if(digits(num) % 2 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    // 2nd method to find total digits
    static int digits2(int num) {
        if (num < 0) {
            num = num * -1;
        }
        if(num == 0){
            return 1;
        }
        return (int)(Math.log10(num)) + 1;
    }

    // Taking each of element and checking its total digit
    static int digits(int num){
        int count = 0;

        // if the number is zero
        if(num == 0){
            count = 1;
        }

        // if the number is negative
        if(num < 0){
            num = num * -1;
        }

        while (num > 0){
            count++;
            num = num / 10; // dividing the number each time by 10 and counting it
        }
        return count;
    }


}
