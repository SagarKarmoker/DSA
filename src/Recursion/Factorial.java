package Recursion;

public class Factorial {

    public static int fact(int n){
        // base case
        if(n == 0){
            return 1;
        }
//        int smallerProblem = fact(n-1);
//        int biggerProblem = n * smallerProblem;
//        return biggerProblem;
        return n * fact(n-1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
}
