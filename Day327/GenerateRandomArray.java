package Day327;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateRandomArray {
    public static int[] generateArray(int min, int max, int size) {
        if (size <= 0 || max - min < size) throw new IllegalArgumentException("invalid input!");
        int[] res = new int[size];
        Set<Integer> set = new HashSet<>();
        int index = 0;
        Random rd = new Random();
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (set.add(num)) {
                res[index++] = num
;            }
        }
        return res;
    }

    public static int[] generateArrayI(int min, int max, int size) {
        if (size <= 0 || max - min < size) throw new IllegalArgumentException("invalid input!");
        int[] res = new int[size];
        boolean[] used = new boolean[max - min + 1];
        Random rd = new Random();
        int index = 0;
        while (index < size) {
            int num = rd.nextInt(max - min + 1) + min;
            if (!used[num - min]) {
                res[index++] = num;
                used[num - min] = true;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray(10, 25, 6)));
        System.out.println(Arrays.toString(generateArrayI(10, 25, 6)));
    }
}
