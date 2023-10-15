package Day323;

import java.util.Arrays;
import java.util.Random;

public class GenerateArray {

    public static int[] generateArray(int min, int max, int size) {
        if (max - min + 1 < size) throw new IllegalArgumentException();
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
        System.out.println(Arrays.toString(generateArray(4, 13, 6)));
    }
}
