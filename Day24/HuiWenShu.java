package Day24;

import java.util.Scanner;

public class HuiWenShu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意五位数的正整数：");
        int n = input.nextInt();
        System.out.println(isHuiWenShu(n) ? "您输入的数字是回文数" : "您输入的数字不是回文数");
        System.out.println(getSum(n));
    }

    public static boolean isHuiWenShu(int n) {
        int one = n % 10;
        int ten = n / 10 % 10;
        int hundred = n / 100 % 10;
        int thousand = n / 1000 % 10;
        int tenThousand = n / 10000 % 10;

        if (one == tenThousand && ten == thousand) {
            return true;
        }
        return false;
    }

    public static int getSum(int n) {
        int one = n % 10;
        int ten = n / 10 % 10;
        int hundred = n / 100 % 10;
        int thousand = n / 1000 % 10;
        int tenThousand = n / 10000 % 10;
        int sum = one + ten + hundred + thousand + tenThousand;
        return sum;
    }
}
