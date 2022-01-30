package LeetCode;

public class LLPalindrome {
    private Node head;

    private static class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val= val;
        }

        public Node(int val, Node node){
            this.val= val;
            this.next = node;
        }
    }

    public void insert(int val){
        Node node = new Node(val);
        node.val = val;
        node.next = null;
        if(head == null){
            head = node;
        }
        head.next = node;
    }

    Node reverse(Node node){
        Node curr = head;
        Node prev = null;

        while (curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    Node middleNode(Node node){
        Node slow = head; // here slow is mid finder(slow works as 1 step while fast works as 2 step at a same time)
        Node fast = head;

        if(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // returning the mid Node
    }

    boolean palindrome(Node node){
        if(head == null){
            System.out.println("LL is empty");
        }
        else {
            Node mid = middleNode(head); // getting the middle node
            Node last = reverse(mid.next); // after mid it will reverse the node and set last node as last
            Node cur = head;
            while (last != null){
                if(last.val != cur.val){
                    return false; // not palindrome
                }
                last = last.next;
                cur = cur.next;
            }
        }
        return true; // palindrome
    }

    public void display(Node node){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LLPalindrome ll = new LLPalindrome();
        /*ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);*/

        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(2);
        n.next.next.next = new Node(2);
        n.next.next.next.next = new Node(2);

        ll.display(n);

        ll.palindrome(n);
    }
}
