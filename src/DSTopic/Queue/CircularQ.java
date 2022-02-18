package DSTopic.Queue;
// without front

public class CircularQ {
    int SIZE;
    int[] items;
    int rear;

    CircularQ(int size){
        SIZE = size;
        rear = -1;
        items = new int[SIZE];
    }

    boolean isFull(){
        return rear == (SIZE - 1);
    }

    boolean isEmpty(){
        return rear == -1;
    }

    public void enQ(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else {
            rear++;
            items[rear] = value;
        }
    }

    public int deQ(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        else {
            int result = items[0];
            for(int i = 0; i < rear;i++){
                items[i] = items[i+1];
            }
            rear--;
            return result;
        }
    }

    public void display(){
        if(rear == -1){
            System.out.println("Queue is empty");
        }
        // i cannot be rear because circular Q
        for (int i = 0; i != rear; i = (i + 1) % SIZE) { // [i = (i + 1) % SIZE] is same as i++
            System.out.print(items[i] + " -> ");
        }
        System.out.println("Front");
    }

    public static void main(String[] args) {
        CircularQ q = new CircularQ(5);

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
