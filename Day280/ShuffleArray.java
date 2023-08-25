package Day280;

import java.util.Random;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;
import static Day65.BubbleSort.swap;

public class ShuffleArray {

    public static <T> void shuffleArray(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            Random rd = new Random();
            int j = rd.nextInt(i);
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
