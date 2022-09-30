package Day25;

public class GetSum2 {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += factorial(i);
        }
        System.out.println(sum);
        System.out.println("============");
        int sum2 = 0;
        for (int i = 1; i <= n ; i++) {
            int x = 1;
            for (int j = 1; j <= i ; j++) {
                x = x * j;
            }
            sum2 += x;
        }
        System.out.println(sum2);
    }

    public static long factorial(int n) {
        return n <= 1 ? 1 : factorial(n - 1) * n;
    }
}
