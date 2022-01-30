package DSTopic.StackTopic;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // constructor with size
    public Stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1; // initializing the top var
    }

    // adding
    public void push(int x){
        if(isFull()){
            System.out.println("Stack is full");
            System.exit(1);
        }
        //System.out.println("Inserting");
        arr[++top] = x; // updating top and adding x to array
    }

    // removing
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return arr[top--];
    }

    boolean isFull(){
        if(top >= (capacity - 1)) {
            return true;
        }else {
            return false;
        }
    }

    boolean isEmpty(){
        if(top <= -1){
            return true;
        }
        else {
            return false;
        }
    }

    public int size(){
        System.out.print("size = ");
        return top + 1; // because top start count from 0
    }

    public void printStack(){
        System.out.println("Printing in Order");
        for(int i = 0; i <= top; i++){
            System.out.println(arr[i]);
        }
    }

    public void printRevStack(){
        System.out.println("Printing in Reverse Order");
        for(int i = top; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());

        stack.printRevStack();

        stack.pop(); // pop will be 5 (because it was added last)
        stack.printRevStack();

        stack.printRevStack();

        System.out.println(stack.size());
    }
}
