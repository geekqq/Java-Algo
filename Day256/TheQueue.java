package Day256;

import java.util.Arrays;

public class TheQueue {

    private String[] queueArray;
    private int queueSize;
    private int front, rear, numberOfItems = 0;



    public void displayQueue() {
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < queueSize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < queueSize; i++) {
            if (queueArray[i].equals("-1")) {
                System.out.print("|     ");
            } else {
                System.out.print(String.format("| %2s " + " ", queueArray[i]));
            }
        }
        System.out.println("|");
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    TheQueue(int size) {
        queueSize = size;
        queueArray = new String[size];
        Arrays.fill(queueArray, "-1");
    }

    public void insert(String input) {
        if (numberOfItems + 1 <= queueSize) {
            queueArray[rear++] = input;
            numberOfItems++;
            System.out.println("INSERT " + input + " was added to the queue!");
        } else {
            System.out.println("Sorry but the queue is full");
        }
    }

    public void remove() {
        if (numberOfItems > 0) {
            System.out.println("REMOVE " + queueArray[front] + " was removed from the queue");
            queueArray[front] = "-1";
            queueSize--;
            front++;
            numberOfItems--;
        } else {
            System.out.println("Sorry but the queue is empty");
        }
    }

    public void peek() {
        if (numberOfItems > 0) {
            System.out.println("The first item in the queue is " + queueArray[0]);
        } else {
            System.out.println("Sorry but the queue is empty");
        }
    }

    // this is wrong
    public void priorityQueueInsert(String input) {
        int i = 0;
        if (numberOfItems == 0) {
            insert(input);
        }
        for (int j = numberOfItems - 1; j >= 0; j--) {
            if (Integer.parseInt(input) > Integer.parseInt(queueArray[j])) {
                queueArray[j + 1] = queueArray[j];
            } else {
                break;
            }
        }
        queueArray[i + 1] = input;
        rear++;
        numberOfItems++;
    }



    public static void main(String[] args) {
        TheQueue queue = new TheQueue(10);
        queue.priorityQueueInsert("10");
        queue.priorityQueueInsert("15");
        queue.priorityQueueInsert("11");
        queue.priorityQueueInsert("19");
        queue.priorityQueueInsert("14");
        queue.displayQueue();

    }
}
