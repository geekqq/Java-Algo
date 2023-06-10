package Day240;

import java.util.Scanner;

public class GetSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            int res = 0;
            for (int j = 0; j < n; j++) {
                res += Math.pow(2, j) * b;
                System.out.print(res + a + " ");
            }
            System.out.println();
        }
    }
}
