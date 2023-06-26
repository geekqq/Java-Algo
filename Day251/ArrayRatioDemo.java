package Day251;

import java.util.Scanner;

public class ArrayRatioDemo {

    public static void plusMinus(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int countPos = 0;
        int countNeg = 0;
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) countPos++;
            else if (arr[i] == 0) countZero++;
            else countNeg++;
        }
        double ratioPos = (double) countPos / arr.length;
        double ratioZero = (double) countZero / arr.length;
        double ratioNeg = (double) countNeg / arr.length;
        System.out.printf("%.6f", ratioPos);
        System.out.println();
        System.out.printf("%.6f", ratioNeg);
        System.out.println();
        System.out.printf("%.6f", ratioZero);
        System.out.println();
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        plusMinus(arr);
    }
}
