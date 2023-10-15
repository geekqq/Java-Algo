package Day324;

import java.util.Random;

import static Day256.PrintArray.printArray;

public class RandomArray {

    public static int[] randomArray(int size, int min, int max) {
        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        Random rd = new Random();
        int index = 0;
        while (index < size){
            int num = rd.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(5, 4, 10);
        printArray(arr);
    }
}
