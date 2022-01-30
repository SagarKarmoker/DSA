package DSTopic.Queue;

public class Queue {

    int SIZE = 5;
    int[] items = new int[SIZE];
    private int front;
    private int rear;

    //constructor that initialize front and rear
    Queue(){
        this.front = -1;
        this.rear = -1;
    }

    boolean isFull(){
        if(front == 0 && rear == (SIZE - 1)){
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(front == -1 && rear == -1){
            return true;
        }
        return false;
    }

    public void enQ(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }
        if(front == -1){  // if there is no item in Queue
            front = 0;
        }
        rear++;
        items[rear] = value;
    }

    public int deQ(){
        int val;
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            val = items[front]; // storing the front element
            if(front >= rear){ // checking the last element and setting is Queue empty
                front = -1;
                rear = -1;
            }
            else {
                front++; // removing front element and push it to forward
            }
            return val; // returning the front element
        }
    }

    public void display(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
        }
        else {
            for(int i = front; i <= rear; i++){    // iterating from front to rear
                System.out.print(items[i] + " -> ");
            }
            System.out.println("Queue end here");
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.deQ();

        q.enQ(1);
        q.enQ(2);
        q.enQ(3);

        q.display();

        q.deQ();
        q.deQ();
        q.display();
    }
}
