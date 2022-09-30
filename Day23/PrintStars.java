package Day23;

import java.util.Scanner;

public class PrintStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要打印的行数：");
        int row = scanner.nextInt();
        printStars(row);
    }

    public static void printStars(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
