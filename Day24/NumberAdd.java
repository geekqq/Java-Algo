package Day24;

import java.util.Scanner;

public class NumberAdd {
    public static void main(String[] args) {
        System.out.println(numAdd(2, 5));
    }

    public static int numAdd(int a, int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                builder.append(a);
            }
            System.out.println(builder);
            sum += Integer.valueOf(builder.toString());
        }
        return sum;
    }
}
