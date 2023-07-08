package Day255;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static int[] randomArray(int size, int max) {
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            int num = rd.nextInt(max + 1);
            arr[i] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArray(10, 100)));
    }
}
