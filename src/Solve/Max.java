package Solve;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    int size= 0;
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            size++;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode rev = reverse(head);
        ListNode temp = head;

        HashSet<Integer> set = new HashSet<>();

        while(temp != null && rev != null){
            int sum = temp.val + rev.val;
            set.add(sum);
            temp = temp.next;
            rev = rev.next;
        }


        int max = Integer.MIN_VALUE;
        for (int var : set) {
            if (var > max)
                max = var;
        }

        return max;

    }

    public static void main(String[] args) {

    }
}