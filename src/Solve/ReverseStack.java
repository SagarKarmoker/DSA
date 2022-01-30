package Solve;

import java.util.Stack;

public class ReverseStack {
    static Stack<Integer> st = new Stack<>();

    public static void insertAtBottom(int c){
        if(st.isEmpty()){
            st.push(c);
        }
        else {
            int top = st.peek();
            st.pop();
            insertAtBottom(c);
            st.push(top);
        }
    }

    public static void reverse(){
        if(st.size() > 0){
            int top = st.peek();
            st.pop();
            reverse();
            insertAtBottom(top);
        }
    }

    public static void main(String[] args) {
        //Stack<Integer> s = new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st);
        reverse();
        System.out.println(st);
    }
}
