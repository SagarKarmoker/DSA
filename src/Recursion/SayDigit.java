package Recursion;

public class SayDigit {

    public static void printDigit(int n, String[] arr){
        // base case
        if(n <= 0){
            return;
        }
        // processing
        int digit = n % 10;
        n = n / 10;

        // recursive call
        printDigit(n, arr); // sending number after dividing like 412->41->4->0
        System.out.println(arr[digit]); // printing the digit
    }

    public static void main(String[] args) {
        String[] arr = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        printDigit(412, arr);
    }
}
