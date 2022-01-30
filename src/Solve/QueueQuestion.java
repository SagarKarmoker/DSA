package Solve;

import java.util.LinkedList;
import java.util.Queue;

public class QueueQuestion {
    public static Queue<Integer> rev(Queue<Integer> q){
        // base case
        if(q.isEmpty()){
            return q;
        }

        // bigger problem in smaller problem
        int data = q.peek(); // getting peek element
        q.remove(); // removing it

        rev(q); // recursively calling

        q.add(data); // adding element to queue

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(14);
        q.add(31);
        q.add(22);
        q.add(10);

        System.out.println(q);

        System.out.println(rev(q));
    }
}
