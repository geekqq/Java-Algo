package Day30;

import java.util.Scanner;

public class OddNumber {
    public static void main(String[] args) {
        System.out.println("请输入任意一个整数：");
        int a = new Scanner(System.in).nextInt();
        if (a % 2 == 0) {
            System.out.println(a + "是偶数");
        } else {
            System.out.println(a + "是奇数");
        }

        System.out.println("请输入另外一个任意整数：");
        int b = new Scanner(System.in).nextInt();
        System.out.println(b % 2 == 0 ? b + "是偶数" : b + "是奇数");
    }
}
