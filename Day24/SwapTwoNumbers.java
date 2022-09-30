package Day24;

import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入a的值：");
        int a = input.nextInt();
        System.out.println("请输入b的值：");
        int b = input.nextInt();

        a = a + b;
        b = a - b;
        //必须要先得到b的值
        System.out.println("交换后b的值是：" + b);
        a = a - b;
        System.out.println("交换后a的值是：" + a);
    }
}
