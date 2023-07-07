package Day254;

import java.util.Arrays;

public class TheStackDemo {
    private String[] stackArray;

    private int stackSize;

    private int topOfStack = -1;

    TheStackDemo(int size) {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        } else {
            System.out.println("Sorry but the stack is full!");
        }
        displayTheStack();
        System.out.println("PUSH " + input + " was added to the stack!\n");
    }

    public String pop() {
        if (topOfStack >= 0) {
            displayTheStack();
            System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack!\n");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        } else {
            displayTheStack();
            System.out.println("Sorry but the stack is empty!");
        }
        return "-1";
    }

    public String peek() {
        displayTheStack();
        System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack!\n");
        return stackArray[topOfStack];
    }

    public void displayTheStack() {
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < stackSize; i++) {
            System.out.format("| %2s "+ " ", i);
        }
        System.out.println("|");
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < stackSize; i++) {
            if (stackArray[i].equals("-1")) {
                System.out.print("|     ");
            } else {
                System.out.print(String.format("| %2s "+ " ", stackArray[i]));
            }
        }
        System.out.println("|");
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void pushMany(String multipleValues) {
        String[] tempStr = multipleValues.split(" ");
        for (int i = 0; i < tempStr.length; i++) {
            push(tempStr[i]);
        }
    }

    public void popAll() {
        for (int i = topOfStack; i >= 0 ; i--) {
            pop();
        }
    }

    public static void main(String[] args) {
        TheStackDemo theStack = new TheStackDemo(10);
        theStack.push("10");
        theStack.push("15");
        theStack.peek();
        theStack.pop();
        theStack.displayTheStack();
        theStack.pushMany("12 13 14 15 16");
        theStack.popAll();
        theStack.displayTheStack();
    }
}
