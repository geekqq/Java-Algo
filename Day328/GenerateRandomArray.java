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
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(max - min) + 1;
            if (set.add(num)) {
                res[i] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRandomArray(5, 25, 10)));
    }
}
