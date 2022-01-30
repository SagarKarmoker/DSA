package DSTopic.StackTopic;
// this code is with using for loop in the push method
// Stack using Singly Linked list

import java.util.Scanner;

public class StackLL2 {
    private Node head;

    private int size;
    private int top = -1;
    int capacity;

    public StackLL2(int size) {
        this.size = size;
        this.capacity = size;
    }

    /*public void push(int value){
        if(top == (size - 1)){
            System.out.println("Stack is full");
        }
        else {
            top++;
            Node node = new Node(value);
            node.value = value;
            if(head == null){
                head = node;
                head.next = null;
            }
            else {
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = node;
                size++;
            }
        }
    }*/

    public void push(){
        if(top == (size - 1)){
            System.out.println("Stack is full");
        }
        else {
            for (int i = 1; i <= capacity; i++) {
                top++;
                Scanner sc = new Scanner(System.in);
                System.out.print("enter " + i + "(push):");
                int in = sc.nextInt();
                Node node = new Node(in);
                node.value = in;
                if (head == null) {
                    head = node;
                    head.next = null;
                } else {
                    Node temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = node;
                    size++;
                }
            }
        }
    }

    public void pop(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            Node temp = head;
            while (temp.next.next != null){
                temp = temp.next;
            }
            top--;
            temp.next = null;
            System.out.println("Popped out the last item");
        }
    }

    public void printStack(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }

    private int peek;
    public void peek(){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        peek = temp.value;
        System.out.println(peek);
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    // main function
    // this code made using the for loop in the push function
    public static void main(String[] args) {
        StackLL2 stackLL = new StackLL2(5); // size of push items

        stackLL.push();
        stackLL.printStack();

        stackLL.pop();
        stackLL.printStack();

        stackLL.pop();
        stackLL.printStack();

        stackLL.peek();
    }
}
