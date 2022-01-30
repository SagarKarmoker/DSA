package LinkedList;

public class ReverseLL {
    // head and tail are pointer(reference variable)
    private Node head; // node which in the start of the list
    private Node tail; // node that is at the last of the list
    private int size;

    // initializing the size 0
    public ReverseLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertAtPosition(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // this function will be deleted the first node of the linked list
    public int deleteFirst() {
        int value = head.value;
        head = head.next; // head will be updated to head next
        if (head == null) {  // head and tail will be null
            tail = null;
        }
        size--; // updating the size by - 1
        return value; // returning the value that was deleted
    }

    public int deleteLast() {
        if (size < 1) {
            return deleteFirst();
        }
        Node secondLast = getIndex(size - 2); // this will be the 2nd last element
        int value = tail.value; // storing the value
        tail = secondLast; // setting the secondLast as tail
        tail.next = null; // tail next will be null
        return value;
    }

    public int deleteAtAnyPosition(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = getIndex(index - 1);
        int value = prev.next.value; // the value of the pre to the next(delete index) value

        prev.next = prev.next.next; // setting to next to (delete index) then next element

        return value;
    }

    // find the value in the list
    public Node findValue(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node getIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    // reverse LL

    Node reverse(Node node){
        Node current = head;
        Node prev = null;

        while(current != null){
            Node temp = head.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    void rev(){
        Node current = head;
        Node prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        list.display();

        list.rev();
        list.display();
    }

}
