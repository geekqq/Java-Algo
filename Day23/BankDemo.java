package Day23;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存款金额：");
        int amount = scanner.nextInt();
        System.out.println("请输入存款年限：");
        int years = scanner.nextInt();
        double outAmount = 0;

        switch (years) {
            case 1:
                outAmount = amount + amount * 2.25 / 100;
                break;
            case 2:
                outAmount = amount + amount * 2.7 / 100 * 2;
                break;
            case 3:
                outAmount = amount + amount * 3.25 / 100 * 3;
                break;
            case 5:
                outAmount = amount + amount * 3.6 / 100 * 5;
        }
        System.out.println("最终您的收益金额为：" + outAmount);
    }
}
