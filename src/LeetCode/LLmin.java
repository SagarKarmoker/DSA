package LeetCode;

import java.util.Stack;

public class LLmin {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        LLmin lLmin = new LLmin();
        lLmin.push(1);
        lLmin.push(2);
        lLmin.push(3);
        lLmin.push(4);

        lLmin.pop();
    }
}
