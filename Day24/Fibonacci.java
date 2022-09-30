package Day24;

import java.util.Scanner;

public class Fibonacci { //TODO: long
    public static void main(String[] args) {
        System.out.println("请输入您要测试的数字：");
        int n = new Scanner(System.in).nextInt();

        if ( n < 1) {
            System.out.println("输入错误！");
        }
        if ( n == 1) {
            System.out.println(0);
        }
        if ( n == 2) {
            System.out.println(0 + "\t" + 1);
        }
        if (n == 3) {
            System.out.println(0 + "\t" + 1 + '\t' + 1);
        }

        if (n > 3) {
            System.out.print(0 + "\t" + 1 + "\t" + 1 + "\t");
        }

        int f1 = 1;
        int f2 = 1;
        int next = 0;
        for (int i = 4; i <= n ; i++) {
            next = f1 + f2;
            f1 = f2;
            f2 = next;
            System.out.print(next + "\t");
        }
    }
}
