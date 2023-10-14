package Day322;

import Day23.RandomDemo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static Day256.PrintArray.printArray;

public class GenerateRandomArrayWithNoDuplicates {

    public static int[] randomArrayNoDuplicates(int min, int max, int len) {
        int[] arr = new int[len];
        Set<Integer> set = new HashSet<>();
        Random rd = new Random();
        for (int i = 0; i < len; i++) {
            int num;
            do {
                num = rd.nextInt(max - min + 1) + min;
            } while (!set.add(num));
            arr[i] = num;
        }
        return arr;
    }

    public static int[] randomArrayI(int min, int max, int len) {
        int[] arr = new int[len];
        Set<Integer> set = new HashSet<>();
        while (set.size() < len) {
            Random rd = new Random();
            int num = rd.nextInt(max - min + 1) + min;
            set.add(num);
        }
        int index = 0;
        for (int i : set) {
            arr[index++] = i;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = randomArrayI(10, 20, 6);
        printArray(arr);
    }
}
