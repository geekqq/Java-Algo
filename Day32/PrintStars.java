package Day32;

import java.util.Scanner;

public class PrintStars {
    public static void main(String[] args) {
        System.out.println("请输入打印的行数：");
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) { //打印的行数
            for (int j = 1; j <= n - i ; j++) { //打印的空格的数量
                System.out.print(" ");
            }
            for (int k = 1; k <= (2*i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
