package Day242;

import java.util.Scanner;

public class Add {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num1 = sc.nextInt();
//        int num2 = sc.nextInt();
//        System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
//        int num3 = sc.nextInt();
//        System.out.println(num1 + "+" + num2 + "+" + num3 + "=" + (num1 + num2 + num3));
//        int num4 = sc.nextInt();
//        System.out.println(num1 + "+" + num2 + "+" + num3 + "+" + num4 + "=" + (num1 + num2 + num3 + num4));
//        int num5 = sc.nextInt();
//        System.out.println(num1+"+"+num2+"+"+num3+"+"+num4+"+"+num5+"=" + (num1+num2+num3+num4+num5));
//        int num6 = sc.nextInt();
//        System.out.println(num1+"+"+num2+"+"+num3+"+"+num4+"+"+num5+"+"+num6+"="+(num1+num2+num3+num4+num5+num6));
        add(6);
    }

    public static void add(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
            System.out.print(i);
            if (i != a[a.length - 1]) {
                System.out.print("+");
            }
            System.out.println("=" + sum);
        }
    }
}
