package Day23;

import java.util.Scanner;

public class PriceToPhone {
    public static void main(String[] args) {
        Scanner phone = new Scanner(System.in);
        System.out.println("请输入您的手机号码：");
        String number = phone.nextLine();
        getPrice(number);
    }

    public static void getPrice(String s) {
        if (s.length() != 11) System.out.println("您输入的手机号码不正确！");
        char c = s.charAt(s.length() - 1);
        if (c == 8) {
            System.out.println("您需要支付办卡费56元！");
        } else if (c == 4) {
            System.out.println("您需要支付办卡费0元！");
        } else {
            System.out.println("您需要支付办卡费20元！");
        }
    }
}
