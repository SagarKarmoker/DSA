package Leet;

public class LL {

    Node head; // node which in the start of the list
    Node tail; // node that is at the last of the list
    int size;

    // initializing the size 0
    public LL() {
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
        System.out.println("End");
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

    public void remove(int val){
        Node node = new Node(0);
        node.next = head;
        Node temp = node;

        while (temp.next != null) {
            if (temp.next.value == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        head = node.next;
    }

    // Merge two sorted linked list
    public static LL merge(LL first, LL second){
        Node p1 = first.head;
        Node p2 = second.head;
        LL newNode = new LL();

        while (p1 != null && p2 != null){
            if (p1.value < p2.value) {
                newNode.insertLast(p1.value);
                p1 = p1.next;
            }else {
                newNode.insertLast(p2.value);
                p2 = p2.next;
            }

            while (p1 != null){
                newNode.insertLast(p1.value);
                p1 = p1.next;
            }

            while (p2 != null){
                newNode.insertLast(p2.value);
                p2 = p2.next;
            }
        }
        return newNode;
    }

    // Binary to decimal
    public void Binary(){
        Node temp = head;
        int ans = 0;
        while (temp != null){
            ans = ans * 2 + temp.value;
            temp = temp.next;
        }
        System.out.println(ans);
    }

    //Linked list Cycle
    boolean cycle(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //length of cycle ll
    public int lengthCycle(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow;
                int len = 0;
                do{
                    temp = temp.next;
                    len++;
                }while (temp != slow);
                return len;
            }
        }
        return 0;
    }

    // middle of the ll
    public void middleOfLL(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        head = slow;
    }

    public static void main(String[] args) {
        LL ll = new LL();

        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        //ll.insertLast(2);
        //ll.display();

        //System.out.println(ll.lengthCycle());
        ll.middleOfLL();
        ll.display();

        //ll.display();

        /*Node node_1 = new Node(1);
        node_1.next = new Node(2);
        node_1.next.next = new Node(4);

        Node node_2 = new Node(1);
        node_2.next = new Node(3);
        node_2.next.next = new Node(4);

        LL ll = new LL();

        ll.display(ll.marge(node_1, node_2));*/

        //ll.display();

        /*LL ll = new LL();

        ll.insertLast(1);
        ll.insertLast(0);
        ll.insertLast(1);

        ll.Binary();*/

//        LL first = new LL();
//        LL second = new LL();
//        first.insertLast(-9);
//        first.insertLast(3);
//        //first.insertLast(5);
//
//        second.insertLast(5);
//        second.insertLast(7);
//        second.insertLast(9);
//        second.insertLast(14);
//
//        LL ans = LL.merge(first, second);
//        ans.display();


    }
}
