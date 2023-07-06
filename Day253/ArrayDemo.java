package Day253;

import Day31.MathRandom;

public class ArrayDemo {

    private int[] theArray = new int[50]; //the array has 50 boxes, capacity
    private int arraySize = 10;

    public void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] =(int) (Math.random() * 10) + 10;
        }
    }

    public void printArray() {
        System.out.println("----------");
        for (int i = 0; i < arraySize; i++) {
            System.out.println("| " + i + " | " + theArray[i] + " |");
        }
        System.out.println("----------");

    }

    public int getValueAtIndex(int index) {
        if (index < arraySize) {
            return theArray[index];
        }
        return 0;
    }

    public boolean doesArrayContainThisValue(int searchValue) {
        boolean valueInArray = false;
        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == searchValue) {
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    public void deleteIndex(int index) {
        if (index < arraySize) {
            for (int i = index; i < arraySize - 1; i++) {
                theArray[i] = theArray[i + 1];
            }
        }
        arraySize--;
    }

    public void insertIndexAtEnd(int value) {

        if (arraySize < 50) {
            theArray[arraySize] = value;
        }
        arraySize++;
    }


    public static void main(String[] args) {
        ArrayDemo newArray = new ArrayDemo();
        newArray.generateRandomArray();
        newArray.printArray();
        System.out.println(newArray.getValueAtIndex(8));
        System.out.println(newArray.doesArrayContainThisValue(11));
        newArray.deleteIndex(4);
        newArray.printArray();
        newArray.insertIndexAtEnd( 0);
        newArray.printArray();
    }
}
