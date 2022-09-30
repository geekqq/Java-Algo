package Day24;

import java.util.Scanner;

public class SwapAandB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入a的值：");
        int a = input.nextInt();
        System.out.println("请输入b的值：");
        int b = input.nextInt();

        a = a + b;
        a = a - a; //not work, because a is already assigned to new a
        System.out.println(a);
    }
}
