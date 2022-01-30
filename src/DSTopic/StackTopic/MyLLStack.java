package DSTopic.StackTopic;

public class MyLLStack {
    private Node head; // works as top

    private int size;

    // default constructor
    public MyLLStack(){
        head = null;
        size = 0;
    }

    public void push(int value){
        Node node = new Node(value);
        node.next = head;
        size++;
        head = node;
    }

    public int pop(){
        if(head == null){
            System.out.println("Stack is empty");
        }
        int current = head.data;
        head = head.next;
        size--;
        return current;
    }

    public void peek(){
        if(head == null){
            System.out.println("Stack is empty");
        }
        System.out.println(head.data); // top of the stack
    }

    boolean isEmpty(){
        if(head == null){
            return true;
        }
        else {
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    public void printStack(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLLStack myLLStack = new MyLLStack();

        myLLStack.push(1);
        myLLStack.push(5);
        myLLStack.push(7);
        myLLStack.push(9);
        myLLStack.printStack();

        System.out.println();
        myLLStack.pop();
        myLLStack.printStack();

        System.out.println();
        myLLStack.peek();
        System.out.println(myLLStack.isEmpty());
        System.out.println(myLLStack.getSize());
    }
}
