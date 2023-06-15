package Day243;

import java.util.Arrays;
import java.util.Scanner;
import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLen = sc.nextInt();
        String[] arr = new String[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            arr[i] = sc.next();
        }


        Arrays.sort(arr, (Object o1, Object o2) -> {
            BigDecimal i = BigDecimal.valueOf(Double.parseDouble(o1.toString()));
            BigDecimal j = BigDecimal.valueOf(Double.parseDouble(o2.toString()));
            return j.compareTo(i);
        });

        for (int i = 0; i < arrayLen; i++) {
            System.out.println(arr[i]);
        }
    }
}
