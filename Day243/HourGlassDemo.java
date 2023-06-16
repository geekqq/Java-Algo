package Day243;

import java.util.Scanner;

public class HourGlassDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int hTop, hMid, hBot;

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                hTop = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                hMid = arr[i + 1] [j + 1];
                hBot = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (hTop + hMid + hBot > maxVal) {
                    maxVal = hTop + hMid + hBot;
                }
            }
        }
        System.out.println(maxVal);
        sc.close();
    }
}
