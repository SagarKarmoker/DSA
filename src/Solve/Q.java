package Solve;

class MyCircularQueue {
    int front;
    int rear;
    int size;
    int[] arr;

    public MyCircularQueue(int k) {
        arr = new int[k];
        this.front = -1;
        this.rear = -1;
        this.size = k;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        else{
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        else{
            if(front >= rear){
                front = -1;
                rear = -1;
            }
            else{
                front = (front + 1) % size;
            }
            return true;
        }
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        else{
            return arr[front];
        }
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        else{
            return arr[rear];
        }
    }

    public boolean isEmpty() {
        if(front == -1){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(front == 0 && rear == (size - 1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println( myCircularQueue.Rear());     // return 4
    }
}

