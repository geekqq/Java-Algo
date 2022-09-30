package Day23;

import java.util.Scanner;

public class NumberOfPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个任意整数：");
        int number = sc.nextInt();
        System.out.println(number + "以内的质数一共有" + numberOfPrimes(number));
    }

    public static int numberOfPrimes(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        int count = 1;
        outer:
        for (int i = 3; i <= n ; i++) {
            //第一次for遍历n以内的从3开始的所有数字，然后判断是否是质数
            for (int j = 2; j < 1 + Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }
}
