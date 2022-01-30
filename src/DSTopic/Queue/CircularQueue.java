package DSTopic.Queue;

public class CircularQueue {
    private int SIZE = 5;
    private int items[] = new int[SIZE];
    private int front;
    private int rear;

    CircularQueue(){
        this.front = -1;
        this.rear = -1;
    }

    CircularQueue(int size){
        this.front = -1;
        this.rear = -1;
        this.SIZE = size;
    }

    boolean isFull(){
        if(front == 0 && rear == (SIZE - 1)){
            return true;
        }
        if(front == (rear + 1)){ // in circular queue, front and rear+1 can not be same because it becomes true
            return true;
        }
        else {
            return false;
        }
    }

    boolean isEmpty(){
        if(front == -1 && rear == -1){
            return true;
        }
        else {
            return false;
        }
    }

    public void enQ(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else {
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % SIZE; // *this one works as rear++ but in different way
            items[rear] = value;
        }
    }

    public int deQ1(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            int val = items[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % SIZE;
            }
            return val;
        }
    }

    public void deQ(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else {
            if(front == rear){
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % SIZE;
            }
        }
    }

    public void display(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
        }
        for (int i = front; i != rear; i = (i + 1) % SIZE) { // i = (i + 1) % SIZE is same as i++
            System.out.print(items[i] + " -> ");
        }
        System.out.println("Front");
    }


    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();

        q.deQ();

        q.enQ(1);
        q.enQ(2);
        q.enQ(3);
        q.enQ(4);
        q.enQ(5);

        q.display();

        q.deQ();
        q.display();

        q.enQ(6);
        q.display();

        q.deQ();
        q.display();
    }
}
