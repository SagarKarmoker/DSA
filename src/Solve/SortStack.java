package Solve;

import java.util.Stack;

public class SortStack {
    public static void sort(Stack<Integer> s, int top) {
        if(s.size() == 0 && s.peek() < top){
            s.push(top);
        }
        else {
            int a = s.peek();
            s.pop();
            sort(s, top);
            s.push(a);
        }
        System.out.println(s);
    }

    public static void reverse(Stack<Integer> s){
        if(s.size() > 0){
            int top = s.peek();
            s.pop();
            reverse(s);
            sort(s, top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        S.push(5);
        S.push(14);
        S.push(3);
        S.push(22);
        S.push(1);
        reverse(S);
    }
}
