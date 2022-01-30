package Solve;

class CustomStack {

    int[] arr;
    int top;
    int size;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        top = -1;
        this.size = maxSize;
    }

    public void push(int x) {
        if(isFull()){
            System.out.println("another elements as size is " + size+1);
        }
        top++;
        arr[top] = x;
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int ele = arr[top];
        top--;
        return ele;
    }

    public boolean isFull(){
        if(top >= (size - 1)){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(top <= -1){
            return true;
        }
        return false;
    }

    public void increment(int k, int val) {
        if(k <= size){
            for(int i = 0; i<k; i++){
                arr[i] = arr[i] + val;
            }
        }
        else {
            for(int i = 0; i<size; i++){
                arr[i] = arr[i] + val;
            }
        }
    }
}

