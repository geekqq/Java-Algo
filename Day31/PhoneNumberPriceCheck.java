package Day31;

import java.util.Scanner;

public class PhoneNumberPriceCheck {
    public static void main(String[] args) {
        System.out.println("请输入您的十一位数的手机号码：");
        String number = new Scanner(System.in).nextLine();

        if (number.length() != 11) {
            System.out.println("您输入的手机号码有误！");
        }

        char c = number.charAt(10);
        double price = 0;

        switch (c) {
            case 8:
                price = 50;
                break;
            case 4:
                price = 0;
                break;
            default:
                price = 20;
                break;
        }
        System.out.println("您需要支付的办卡费是：" + price + "元。");
    }
}
