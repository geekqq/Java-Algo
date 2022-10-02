package Day31;

import java.util.Scanner;

public class BankDeposit {
    public static void main(String[] args) {
        System.out.println("请输入定存年限，只能选择一年，两年，三年或者五年：");
        int year = new Scanner(System.in).nextInt();
        System.out.println("请输入存款金额：");
        double amount = new Scanner(System.in).nextDouble();
        double outMoney = 0;
        switch (year) {
            case 1:
                outMoney = amount + amount * 2.25 / 100* year;
                System.out.println(outMoney);
                break;
            case 2:
                outMoney = amount + amount * 2.7 / 100* year;
                System.out.println(outMoney);
                break;
            case 3:
                outMoney = amount + amount * 3.25 / 100* year;
                System.out.println(outMoney);
                break;
            case 5:
                outMoney = amount + amount * 3.6 / 100 * year;
                System.out.println(outMoney);
                break;
            default:
                System.out.println("输入不正确！");
                break;
        }
    }
}
