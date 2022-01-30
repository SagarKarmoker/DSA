package Recursion;

public class ReverseString {

    public static String reverse(String s){
        if(s.length() == 1){
            return s;
        }

        char curr = s.charAt(0);
        String next = reverse(s.substring(1));
        System.out.println(curr + " " + next);
        return next + curr;
    }

    public static void main(String[] args) {
        String s = "sagar";
        System.out.println(s);
        System.out.println(reverse(s));
    }
}
