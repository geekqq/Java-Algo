package Day275;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class GetSecondLargest {

    public static int getSecondMax(int[] arr) {
        if (arr == null || arr.length <= 1) throw new IllegalArgumentException("Invalid input!");
        int max = arr[0];
        int secondMax = max;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static int[] randomArrayNoDuplicates(int size, int min, int max) {
        if (size > max - min + 1) {
            throw new IllegalArgumentException();
        }

        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        int index = 0;
        Random rd = new Random();
        while ( index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                arr[index++] = num;
                used[num - min] = true;
            }
        }
        return arr;
    }

    public static int get2ndMax(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }
        pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 18);
        printArray(arr);
        System.out.println(getSecondMax(arr));
        System.out.println(get2ndMax(arr));

        int[] newArr = randomArrayNoDuplicates(10, 5, 29);
        printArray(newArr);
        System.out.println(getSecondMax(newArr));
        System.out.println(get2ndMax(newArr));
    }
}
