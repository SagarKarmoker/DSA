package Solve;

import java.util.*;

/* Java Program to move last element to front in a given linked list */
class Linked_List
{
    Node head; // head of list

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

    static void reverse(Node head)
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

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        Linked_List llist = new Linked_List();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.printList();

        //llist.moveToFront();
        //reverse(llist.head);
        digit(llist.head);

        llist.printList();
    }
}

