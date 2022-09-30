package Day24;

import java.util.Scanner;

public class TaxiFair {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入本次出行的公里数：");
        double distance = input.nextDouble();
        if (distance <= 2) {
            double fair  = 8;
            System.out.println("本次出行的费用为：" + fair);
        } else if (distance > 2) {
            double fair = 4.5 * distance;
            System.out.println("本次出行的费用为：" + fair);
        }
    }
}
