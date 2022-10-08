package Day37;

import java.util.Arrays;
import java.util.Collections;

public class GetMaxAndMin {
    public static void main(String[] args) {
        Integer[] numbers = {8,2,7,1,4,9,5,0,-1};

        int min = Collections.min(Arrays.asList(numbers));
        int max = Collections.max(Arrays.asList(numbers));

        System.out.println("min is: " + min);
        System.out.println("max is: " + max);

        int min1 = numbers[0];
        int max1 = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (min1 > numbers[i]) {
                min1 = numbers[i];
            }
            if (max1 < numbers[i]) {
                max1 = numbers[i];
            }
        }
        System.out.println(min);
        System.out.println(max);

    }
}
