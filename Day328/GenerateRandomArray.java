package Day328;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateRandomArray {
    public static int[] generateRandomArray(int min, int max, int size) {
        if (size <= 0 || size > max - min) throw new IllegalArgumentException("Invalid input!");
        int[] res = new int[size];
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();
        int index = 0;
        while (index < size){
            int num = rand.nextInt(max - min + 1) + min;
            if (set.add(num)) {
                res[index++] = num;
            }
        }
        return res;
    }

    public static int[] generateArray(int min, int max, int size) {
        if (size <= 0 || max - min < size) throw new IllegalArgumentException("Invalid input!");
        int[] res = new int[size];
        boolean[] used = new boolean[max - min + 1];
        Random rand = new Random();
        int index = 0;
        while (index < size){
            int num = rand.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                res[index++] = num;
                used[num - min] = true;
            }
        }
        return res;
    }

    public static int[] generateArrayI(int size, int min, int max) {
        if (max - min + 1 < size) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        boolean[] used = new boolean[max - min + 1];
        Arrays.fill(used, true);
        Random rd = new Random();
        int index = 0;
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (used[num - min]) {
                arr[index++] = num;
                used[num - min] = false;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRandomArray(5, 25, 10)));
        System.out.println(Arrays.toString(generateArray(5,25,10)));
        System.out.println(Arrays.toString(generateArrayI(5,10,25)));
    }
}
