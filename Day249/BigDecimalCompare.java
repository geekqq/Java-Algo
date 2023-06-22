package Day249;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimalCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Comparator<String> myComparator = (o1, o2) -> {
            BigDecimal b1 = new BigDecimal(o1);
            BigDecimal b2 = new BigDecimal(o2);

            return b2.compareTo(b1);
        };

        Arrays.sort(arr, 0, n, myComparator);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
