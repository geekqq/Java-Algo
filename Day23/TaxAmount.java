package Day23;

import java.util.Scanner;

public class TaxAmount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的税前收入：");
        double income = sc.nextDouble();
        System.out.println("应缴税额为：" + taxAmount(income));
        System.out.println("您的税后收入为：" + (income * 0.9 - taxAmount(income)));
    }

    public static double taxAmount(double income) {
        double taxable = income * 0.9 - 5000;
        double taxAmount = 0;
        if (taxable > 0 && taxable <= 3000) taxAmount = taxable * 0.03;
        else if (taxable > 3000 && taxable <= 12000) taxAmount = 3000 * 0.03 + (taxable - 3000) * 0.1;
        else if (taxable > 12000 && taxable <= 25000) taxAmount = 3000 * 0.03 + 9000 * 0.1 + (taxable - 12000) * 0.2;
        else if (taxable > 25000 && taxable <= 35000) taxAmount = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + (taxable - 25000) * 0.25;
        else if (taxable > 35000 && taxable <= 55000) taxAmount = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + (taxable - 35000) * 0.3;
        else if (taxable > 55000 && taxable <= 80000) taxAmount = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + (taxable - 55000) * 0.35;
        else if (taxable > 80000) taxAmount = 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + 25000 * 0.35 + (taxable - 80000) * 0.45;
        return taxAmount;
    }
}
