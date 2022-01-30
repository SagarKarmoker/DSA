package Solve;

import java.util.*;

class MyStack {

    Queue<Integer> a = new LinkedList<>();
    Queue<Integer> b = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        a.add(x);
    }

    public int pop() {
        while (a.size() != 1){
            b.add(a.remove());
        }
        int ans = a.remove();
        while (!b.isEmpty()){
            a.add(b.remove());
        }

        return ans;
    }

    public int top() {
        while (a.size() != 1){
            b.add(a.remove());
        }
        int ans = a.peek();
        while (!b.isEmpty()){
            a.add(b.remove());
        }

        return ans;
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }

//    public int kSimilarity(String s1, String s2) {
//        ArrayList<Character> ch = new ArrayList<>();
//
//        for(char c : s1.toCharArray()){
//            ch.add(c);
//        }
//
//
//
//        StringBuilder sb = new StringBuilder();
//
//    }


}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
