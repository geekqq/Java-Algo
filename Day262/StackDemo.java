package Day262;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class StackDemo {

    ListNode top;
    int size;

    public StackDemo() {
        top = null;
        size = 0;
    }



    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        ListNode temp = top;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;

        }
        System.out.print("null\n");
    }

    public void push(int val) {
        ListNode temp = new ListNode(val);
        temp.next = top;
        top = temp;
        size++;
    }

    public int pop() {
        ListNode temp = top;
        if (top == null) {
            throw new NoSuchElementException("The stack is empty!");
        }
        top = top.next;
        size--;
        return temp.val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.val;
    }
    public static void main(String[] args) {
        StackDemo stack = new StackDemo();
        stack.push(1);
        stack.push(2);
        stack.display();
        System.out.println("---pop---");
        System.out.println(stack.pop());
        System.out.println("---peek---");
        System.out.println(stack.peek());
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}