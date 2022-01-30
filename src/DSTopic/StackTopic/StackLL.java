package DSTopic.StackTopic;

public class StackLL {
    private Node head;

    private int size;
    private int top = -1;
    int capacity;

    public StackLL() {
        this.size = 0;
    }

    public void push(int value){
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
}
