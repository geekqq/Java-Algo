package Day30;

import java.util.Scanner;

public class GetMaxInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input number a: ");
        int a = input.nextInt();
        System.out.println("input number b: ");
        int b = input.nextInt();
        System.out.println("input number c: ");
        int c = input.nextInt();

        int max = a > b ? a : (b > c ? b : c);
        System.out.println("三个数字中的最大数字是： " + max);
    }
}
