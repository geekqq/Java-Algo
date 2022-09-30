package Day23;

import java.util.Scanner;

public class TestPrint {
    public static void main(String[] args) {
        String name = "派大星";
        int year = 1;
        double salary = 10000.00;
        System.out.println(name + ": 这是我学习Java的第" + year + "年， 我的期望薪资是" + salary);

        int number1 = 1;
        int number2 = 2;
        System.out.println(number1 + number2);
        System.out.println(number1 - number2);
        System.out.println(number1 * number2);
        System.out.println(number1 / number2);
        System.out.println(number1 % number2);
        System.out.println("----------");
        double fatherHeight = 175.0;
        double motherHeight = 160.0;
        System.out.println("预测的儿子的身高：" + (fatherHeight + motherHeight) * 1.08 / 2);
        System.out.println("预测的女儿的身高：" + (fatherHeight * 0.923 + motherHeight) / 2);
        System.out.println("----------");
        int red = 25;
        int blue  = 30;
        red = red * 2 + 10;
        blue = blue * 2;
        System.out.println(red == blue);
        System.out.println("----------");
        double money1 = 24 + 8 + 3;
        money1 = money1 < 30 ? money1 : money1 * 0.8;
        double money2 = 16 + 8 + 3;
        double money = money1 > money2 ? money2 : money1;
        System.out.println(money);
        System.out.println("----------");
        System.out.println("请输入第一个数字：");
        int a = new Scanner(System.in).nextInt();
        System.out.println("请输入第二个数字：");
        int b = new Scanner(System.in).nextInt();
        System.out.println("请输入第三个数字：");
        int c = new Scanner(System.in).nextInt();
        int max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println("三个数字中的最大值是：" + max);
        System.out.println("----------");
        System.out.println("请输入要判断的数字：");
        int num = new Scanner(System.in).nextInt();
        System.out.println(num % 2 == 0 ? "偶数" : "奇数");
        System.out.println("----------");
    }
}
