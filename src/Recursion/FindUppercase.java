package Recursion;

public class FindUppercase {
    public static char find(String s, int i){
        // base case
        if(i == s.length()){
            return 0;
        }

        if(Character.isUpperCase(s.charAt(i))){
            return s.charAt(i);
        }
        return find(s, i+1);
    }
    public static void main(String[] args) {
        String str = "gEeksforGeeKS";
        System.out.println(find(str, 0));
    }
}
