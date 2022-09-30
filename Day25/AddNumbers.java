package Day25;

import java.util.Scanner;

public class AddNumbers {
    public static void main(String[] args) {
        System.out.println("input n: ");
        int n = new Scanner(System.in).nextInt();
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                builder.append("2");
            }
            sum += Integer.valueOf(builder.toString());
            System.out.println(builder);
            System.out.println(sum);
        }
    }
}
