package Solve;
import java.util.LinkedList;

class FrontMiddleBackQueue {

    static LinkedList<Integer> ll;

    public FrontMiddleBackQueue() {
        ll = new LinkedList<>();
    }

    public void pushFront(int val) {
        ll.add(0, val);
    }

    public void pushMiddle(int val) {
        int mid = ll.size()/2;
        ll.add(mid, val);
    }

    public void pushBack(int val) {
        ll.add(val);
    }

    public int popFront() {
        if(ll.isEmpty()){
            return -1;
        }
        return ll.remove(0);
    }

    public int popMiddle() {
        if(ll.isEmpty()){
            return -1;
        }
        return ll.remove((ll.size() - 1)/ 2);
    }

    public int popBack() {
        if(ll.isEmpty()){
            return -1;
        }
        return ll.removeLast();
    }

    public static void display(){
        for (Integer integer : ll) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        display();
        //q.popFront();     // return 1 -> [4, 3, 2]
        System.out.println(q.popFront());
        //display();
//        q.popMiddle();    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());
        //display();
//        q.popMiddle();    // return 4 -> [2]
        System.out.println(q.popMiddle());
        //display();
//        q.popBack();      // return 2 -> []
        System.out.println(q.popBack());
        //display();
//        q.popFront();     // return -1 -> [] (The queue is empty)
        System.out.println(q.popFront());
        display();
    }
}
