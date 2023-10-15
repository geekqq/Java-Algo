package Day324;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static int[] generateArraySet(int size, int min, int max) {
        if (max - min + 1 < size) throw new IllegalArgumentException();
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[size];
        Random rd = new Random();
        while (set.size() < size){
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
        int[] arr = generateArraySet(5, 4, 10);
        printArray(arr);
    }
}
