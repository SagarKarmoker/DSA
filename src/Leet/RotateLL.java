package Leet;

public class RotateLL {
    Node head; // node which in the start of the list
    Node tail; // node that is at the last of the list
    int size;

    // initializing the size 0
    public RotateLL() {
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

    // LeetCode problems

    //Rotate Right LL
    public void rotateRight(int k) {
        for (int i = 1; i <= k; i++) {
            Node newNode = head;
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
            head.next = newNode;
        }
    }

    public void rotateRight1(Node node, int k) {
        Node newNode;
        for (int i = 1; i <= k; i++) {
            newNode = head;
            Node temp = newNode;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
            head.next = newNode;
        }
    }

    //reverse the node
    public void reverse(){
        Node cur = head;
        Node prev = null;

        while (cur != null){
            Node temp =  cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head = prev;
    }

    // remove nth node from last
    public void removeNthFromEnd(int n){
        Node start = new Node(0);
        start.next = head; // adding the node at begening

        Node fast = start;
        Node slow = start;

        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        //start.next = head; // start.next
    }

    // Swapping Nodes in a Linked List
    public void swapNodes(int k) {
        Node start = new Node(0);
        start.next = head;

        Node fast = start;
        Node slow = start.next;

        for(int i = 1; i<= k; i++){
            fast = fast.next;
        }

        Node temp = fast;

        while (temp.next != null){
            temp = temp.next;
            slow = slow.next;
        }

        int a = fast.value;
        int b = slow.value;

        //swapping the number
        int tempVar;
        tempVar = a;
        a = b;
        b = tempVar;

        fast.value = a;
        slow.value = b;

    }

    // Delete middle of ll
    public void deleteMiddle(){
        Node start = new Node(0);
        start.next = head;

        Node fast = start;
        Node slow = start;

        Node temp = head;
        int count = 0;
        while (temp.next != null){
            count++;
            temp = temp.next;
        }

        for(int i = 0; i <= (count / 2); i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

    }

    // Add two number
    public void addTwoNumbers(Node l1, Node l2) {
        Node p1 = l1;
        Node p2 = l2;

        int num1 = 0, num2 = 0, ans = 0;
        while(p1.next != null){
            num1 = (p1.value * 10) + p1.next.value;
            p1 = p1.next;
        }

        while(p2.next != null){
            num2 = (p2.value * 10) + p2.next.value;
            p2 = p2.next;
        }

        ans = num1 + num2;
        int len;
        len = count(ans);
        int rem = 0;

        Node newNode = new Node(0);

        for(int i = 0; i < len; i++){
            rem = ans % 10;
            ans = ans / 10;
            newNode.next.value = rem;
        }

        head = newNode;

    }

    public int count(int n){
        int len = 0;
        while(n != 0){
            n = n/10;
            len++;
        }
        return len;
    }

    public int convert(){
        Node p1 = head;
        int num1 = 0;
        while(p1.next.next != null){
            num1 = (p1.value * 10) + p1.next.value;
            p1 = p1.next;
        }
        return num1;
    }

    // Remove Duplicates from sorted list
    public void removeDub(){
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (head != null){
            if(head.next != null && head.value == head.next.value){
                // this while loop will work when values are same
                while (head.next != null && head.value == head.next.value){
                    head = head.next;
                }
                prev.next = head.next;
            }
            else {
                prev = prev.next;
            }
            head = head.next;
        }

        head = dummy.next;
    }

    public void addTwoNum(Node l1, Node l2){
        Node dummy = new Node(0);
        Node temp = dummy; // copy of dummy node

        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0;
            if(l1 != null){
                sum += l1.value;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.value;
                l2 = l2.next;
            }

            sum = carry + sum;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }

        head = dummy.next;
    }


    //main
    public static void main(String[] args) {
        RotateLL ll = new RotateLL();

//        ll.insertLast(1);
//        ll.insertLast(2);
//        ll.insertLast(2);
//        ll.insertLast(3);
////        ll.insertLast(4);
////        ll.insertLast(5);
////        ll.insertLast(6);
//        ll.display();
//
//        //ll.addTwoNumbers();
//        //ll.display();
//
//        ll.removeDub();
//        ll.display();

        Node n1 = new Node(2);
        n1.next.value = 3;
        n1.next.next.value = 4;

        Node n2 = new Node(5);
        n2.next.value = 6;
        n2.next.next.value = 4;

        ll.addTwoNum(n1, n2);
        ll.display();
    }
}
