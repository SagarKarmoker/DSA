package Solve;

import java.util.*;

public class StackQ {

    /**
     * int[] num1 = {4,1,2};
     * int[] num2 = {1,3,4,2};
     * System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        int k = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int max = nums1[j];
                if(nums1[i] == nums2[j]){
                    ans[k] = -1;
                }
                else if(nums2[j] > nums1[i]){
                    ans[k] = nums2[j];
                    //break;
                }
            }
            k++;
        }
        return ans;
    }

    /**
     * [2,4]
     * [1,2,3,4]
     *
     */

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();

    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else {
                if(stack.peek() == c){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }

        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> newQ = new LinkedList<>();

        for(int i = 1; i <= k; i++){
            if(stack.size() <= k){
                stack.push(q.poll());
            }
        }

        int cnt = 0;
        while (cnt != k){
            newQ.add(stack.pop());
            cnt++;
        }

        while (!q.isEmpty()){
            newQ.add(q.poll());
        }

        return newQ;
    }

    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        Stack<Integer> store = new Stack<>();
        int mid = sizeOfStack / 2;
        int cnt = 0;
        while (cnt != mid+1){
            store.push(s.pop());
            cnt++;
        }
        store.pop();
        while (!store.isEmpty()){
            s.push(store.pop());
        }
    }

    public static int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                count--;
                stack.pop();
            }
            else if(c == '(') {
                stack.push(')');
                count++;
            }
            else if(c == '{') {
                stack.push('}');
                count++;
            }
            else if(c == '[') {
                stack.push(']');
                count++;
            }
            else if(stack.isEmpty() || stack.peek() != c){
                count++;
            }
        }
        return count;
    }

    public static int minAddToMakeValid1(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }

    /**
     * Input: asteroids = [5,10,-5]
     * Output: [5,10]
     * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
     * @param asteroids
     * @return
     */

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(stack.isEmpty()){
                stack.push(a);
            }
            else if(stack.peek() <= a && a >= 0){
                stack.push(a);
                break;
            }
            else if(stack.peek() < a && a < 0){
                stack.push(a);
                break;
            }
            else if(stack.peek() < a){
                stack.pop();
                stack.push(a);
                break;
            }
            else if((stack.peek() + a) == 0){
                stack.pop();
                break;
            }
        }

        ArrayList<Integer> aa = new ArrayList<>(stack);
        int[] arr = new int[aa.size()];

        int k = 0;
        for(int i : aa){
            arr[k] = i;
            k++;
        }
        return arr;
    }

    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(stack.isEmpty() || a > 0){
                stack.push(a);
            }
            else{
                while (true){
                    if(stack.peek() < 0){
                        stack.push(a);
                        break;
                    }
                    else if(stack.peek() == -a){
                        stack.pop();
                        break;
                    }
                    else if(stack.peek() >= -a){
                        break;
                    }
                    else {
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.push(a);
                            break;
                        }
                    }
                }
            }
        }

        ArrayList<Integer> aa = new ArrayList<>(stack);
        int[] arr = new int[aa.size()];

        int k = 0;
        for(int i : aa){
            arr[k] = i;
            k++;
        }
        return arr;
    }

    public static int[] calculateSpan(int price[], int n)
    {
        int[] spans = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        spans[0] = 1;
        for(int i = 1; i < price.length; i++){
            System.out.println(stack.peek());
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                spans[i] = i+1;
            }
            else {
                spans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return spans;
    }

    public static String reverse(String S){
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder(S.length());
        for(int i = 0; i < S.length(); i++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // O(n)
    public static long[] nextLargerElement1(long[] arr, int n)
    {
        Stack<Long> st = new Stack<>();
        long[] next = new long[n];

        for (int i = arr.length-1; i >= 0;i--){
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                next[i] = -1;
            }
            else {
                next[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return next;
    }

    // Big O(n^2)
    public static int[] nextLargerElement(int[] arr, int n)
    {
        int[] a = new int[n];
        for(int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    a[i] = arr[j];
                    break;
                }
                else{
                    a[i] = -1;
                }
            }
        }

        return a;
    }

    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack<>();
        for(char c : S.toCharArray()){
            int ans = 0;
            if(st.isEmpty()){
                st.push(Integer.parseInt(String.valueOf(c)));
            }
            else if(c == '*' || c == '/' || c == '+' || c == '-'){
                int y = st.pop();
                int x = st.pop();

                if(c == '*'){
                    ans = x * y;
                }
                else if(c == '/'){
                    if(y == 0){
                        ans = 0;
                    }
                    else {
                        ans = x / y;
                    }
                }
                else if(c == '+'){
                    ans = x + y;
                }
                else {
                    ans = x - y;
                }
                st.push(ans);
            }
            else{
                st.push(Integer.parseInt(String.valueOf(c)));
            }
        }
        return st.pop();
    }

    static void insertToBottom(Stack<Integer> S, int N){
        Stack<Integer> temp = new Stack<>();
        while (!S.isEmpty()){
            temp.push(S.peek());
            S.pop();
        }
        S.push(N);
        while (!temp.isEmpty()){
            S.push(temp.pop());
        }

        System.out.println(S);
    }

    // using recursion
    static void insertToBottomRecursion(Stack<Integer> S, int N){
        // base case
        if(S.size() == 0){
            S.push(N);
        }
        else {
            // Recursive call
            int X = S.peek();
            S.pop();
            insertToBottomRecursion(S, N);
            S.push(X);
        }
        System.out.println(S);
    }




    public static void main(String[] args) {
//        String s = "))()((";
//        System.out.println(minAddToMakeValid1(s));
//        String s = "azxxzy";
//        System.out.println(removeDuplicates(s));

//        int[] arr = {-2,-2,-2,-2};
//        System.out.println(Arrays.toString(asteroidCollision1(arr)));
//        int[] arr = {100, 80, 60 ,70, 60, 75 ,85};
//        int n = 7;
//        System.out.println(Arrays.toString(calculateSpan(arr, n)));

//        String S="GeeksforGeeks";
//        System.out.println(reverse(S));

//        long[] arr = {1, 3, 2, 4};
//        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
//        long[] arr = {7, 8, 1, 4};
//        int n = 4;
//        System.out.println(Arrays.toString(nextLargerElement1(arr, n)));

//        String s = "49*7+";
//        System.out.println(evaluatePostFix(s));

//        Stack<Integer> S = new Stack<>();
//        S.push(5);
//        S.push(14);
//        S.push(3);
//        S.push(22);
//        S.push(1);
//        System.out.println(sort(S));

//
//        int N = 7;
//
//        //insertToBottomRecursion(S, N);

    }
}
