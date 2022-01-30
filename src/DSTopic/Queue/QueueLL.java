package DSTopic.Queue;
// Queue using Linked list

public class QueueLL {
    Node front;
    Node rear;

    class Node{
        int data;
        Node next;

        Node(int val){
            this.data = val;
        }
    }

    public void enQueue(int val){
        Node node = new Node(val);
        if(front == null){
            front = rear = node;
        }
        rear.next = node;
        rear = node;
    }

    public void deQueue(){
        if(front == null){
            System.out.println("Queue is empty");
        }
        front = front.next;
    }

    public void display(){
        Node temp = front;
        while (temp.next != null){
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLL qList = new QueueLL();

        qList.enQueue(1);
        qList.enQueue(2);
        qList.enQueue(3);
        qList.enQueue(4);

        qList.display();

        qList.deQueue();
        qList.display();
    }
}
