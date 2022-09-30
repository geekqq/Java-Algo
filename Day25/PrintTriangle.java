package Day25;

import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] args) {
        System.out.println("请输入打印星星的行数：");
        int n = new Scanner(System.in).nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
