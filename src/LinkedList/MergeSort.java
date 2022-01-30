package LinkedList;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{

    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = new Solution().mergeSort(head);
            printList(head);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
            return;

        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.

    static Node sortList(Node low, Node high){
        Node ans = null;

        if(low == null){
            return high;
        }
        if(high == null){
            return low;
        }

        if(low.data <= high.data){
            ans = low;
            ans.next = sortList(low.next, high);
        }
        else{
            ans = high;
            ans.next = sortList(low, high.next);
        }

        return ans;
    }

    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null; // end of 2nd list

        Node left = mergeSort(head);
        Node right = mergeSort(midNext);

        Node list = sortList(left, right);
        return list;
    }



    static Node getMiddle(Node head){
        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}



