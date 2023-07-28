package Day262;

public class Stack {

    private int top;
    private int[] arr;

    public Stack(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public  Stack() {
        this(10);
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return arr.length == size();
    }

    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Stack is full!!");
        }

        //top++;
        arr[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!!");
        }
        int res = arr[top];
        top--;
        return res;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!!");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(12);
        stack.push(13);
        stack.push(13);
        System.out.println(stack.peek());
    }
}
