package Solve;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class getMin
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Taking all the testcases
        int t = sc.nextInt();

        while(t-- > 0)
        {
            //Taking total number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];

            //adding all the elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            //calling _push method of class GetMin
            //and storing the result in a new Stack
            Stack<Integer>mys = new GetMin()._push(arr,n);

            //calling _getMinAtPop method of class GetMin
            new GetMin()._getMinAtPop(mys);
            System.out.println();
        }
    }
}

class GetMin
{
    //Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[],int n)
    {
        Stack<Integer> st = new Stack<>();
        Arrays.sort(arr);
        for(int i = n-1; i >= 0; i--){
            st.push(arr[i]);
        }

        return st;
    }

    //Function to print minimum value in stack each time while popping.
    public static void _getMinAtPop(Stack<Integer>s)
    {
        int min = s.peek();
        while(s.size() != 0){
            if(min <= s.peek()){
                System.out.print(min + " ");
                s.pop();
            }
            else{
                min = s.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1 ,34 ,23, 17, 37 ,42, 13, 39, 0, 53, 49 ,6, 71};
        _getMinAtPop(_push(arr, 13));
    }
}
