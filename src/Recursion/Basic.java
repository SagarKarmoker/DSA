package Recursion;

public class Basic {
    public static void print(int n){
        // base case
        if(n == 0){
            return;
        }
        //System.out.println(n);

        // recursive relation
        print(n-1);
        // After recursive call
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
