package Day00;

import java.util.Scanner;

public class DemoAddTwoNumbers {
    public static void main(String[] args) {
        int x, y, sum;
        Scanner myObj = new Scanner(System.in);
        System.out.println("请输入x的值：");
        x = myObj.nextInt();
        System.out.println("请输入y的值：");
        y = myObj.nextInt();
        sum = x + y;
        System.out.println("x与y的和是：" + sum);
    }
}
