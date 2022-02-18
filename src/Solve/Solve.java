package Solve;

import java.util.*;

/* Java Program to move last element to front in a given linked list */
class Linked_List
{
    static Node head; // head of list

    /* Linked list Node*/
    static class Node
    {
        int data;
        Node next;
        Node(){

        }
        Node(int d) {data = d; next = null; }
    }

    void moveToFront()
    {
        if(head == null || head.next == null)
            return;

		Node temp = head;
        Node newNode = null;
        while(temp.next != null){
            newNode = temp;
            temp = temp.next;
        }

        newNode.next = null;
        temp.next = head;
        head = temp;
    }

    static void reverseLL(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void digit(Node head){
        Node temp = head;
        int digit = head.data;
        while (temp.next != null){
            digit = digit * 10 + temp.next.data;
            temp = temp.next;
        }
        digit = digit + 1;

        List<Integer> list = new ArrayList<>();
        while (digit > 0){
            int num = digit % 10;
            digit = digit / 10;
            list.add(num);
        }
    }

    // find loop in a linked list is present or not (book problem no: 9 & 10)
    public static void findLoop(Node head){
        HashSet<Node> hashSet = new HashSet<>();
        Node temp = head;
        while (temp != null){
            if(hashSet.contains(temp)){
                System.out.println("found the loop");
            }
            else{
                hashSet.add(temp);
            }
            temp = temp.next;
        }
    }

    // another solution
    public static boolean findLoop2(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // find nth node from the end of linked list
    // using recurison
    public static Node calNth(Node head, int nth){
        int count = 0;
        if(head != null){
            calNth(head.next, nth);
            count++;
            if(nth == count){
                return head;
            }
        }
        return null;
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head){
        Node cur = Linked_List.head;
        Node prev = null;

        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    public static boolean isPalindrome(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        Node rev = reverse(head);

        while(rev != null){
            list.add(rev.data);
            rev = rev.next;
        }


        boolean flag = false;

        int i = 0;
        while(temp != null){
            if(temp.data == list.get(i)){
                flag = true;
            }
            else{
                flag = false;
            }
            temp = temp.next;
        }

        return flag;
    }

    public static int firstUniqChar(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        char[] c = s.toCharArray();

//        for(int i = 0; i < s.length(); i++){
//            ch[i] = c[i];
//        }
        int idx = 0;
//        for(int i = 0; i < s.length(); i++){
//            for(int j = 0; j < s.length(); j++){
//                if (c[i] == c[j]) {
//                    idx = i - 1;
//                    break;
//                }
//            }
//        }

        for(int i = 1; i < s.length(); i++){
            if(c[i-1] != ch[i]){
                idx = i;
                break;
            }else{
                idx = -1;
            }
        }
        return idx;
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }
            else if(st.peek() != c){
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }

        return sb.toString();
    }

    public static boolean isLengthEvenorOdd()
    {
        Node temp = head;
        boolean s = false;
        while(temp != null){
            if(temp.data % 2 != 0){
                s = false;
                break;
            }
            else{
                s = true;
            }
            temp = temp.next;
        }
        return s;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        Linked_List llist = new Linked_List();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(10);
        llist.push(4);
        llist.push(21);
        llist.push(2);
        llist.push(8);

        llist.printList();

        //llist.moveToFront();
        //reverse(llist.head);
//        digit(llist.head);
//
//        llist.printList();

//        llist.push(1);
//        llist.push(2);
//        llist.push(1);
//        llist.push(1);
//
//        llist.printList();
//        System.out.println(isPalindrome(head));


//        System.out.println(firstUniqChar("loveleetcode"));

//        System.out.println(removeOuterParentheses("()()"));
        System.out.println(isLengthEvenorOdd());

    }
}

