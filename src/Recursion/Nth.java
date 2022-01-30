package Recursion;

public class Nth {

    public static int count(int steps){
        // RR: f(n) = f(n-1)+f(n-2)
        // base case
        if(steps < 0){
            return 0;
        }
        if(steps == 0){
            return 1;
        }

        return count(steps-1) + count(steps - 2);
    }

    public static void main(String[] args) {
        System.out.println(count(10));
    }
}
