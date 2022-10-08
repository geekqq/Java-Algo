package Day37;

import java.util.Arrays;

public class ArrayFillDemo {
    public static void main(String[] args) {
        int[] array = new int[6];
        //Arrays.fill(arrayName, value)
        Arrays.fill(array, 100);
        System.out.println(Arrays.toString(array));
        //Arrays.fill(arrayName, starting index, ending index(not included), value)
        Arrays.fill(array, 3, 6, 50);
        System.out.println(Arrays.toString(array));
    }
}
