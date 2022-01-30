package Recursion;

public class Power {

    public static int pow(int n){
        //base case
        if(n == 0){
            return 1;
        }
//        int smallerProblem = pow(n -1);
//        int biggerProblem = 2 * smallerProblem;
//        return biggerProblem;
        return 2 * pow(n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(pow(n));
    }
}
