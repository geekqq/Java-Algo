package Day23;

public class IsWanshu {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(isWanshu(n));
        System.out.println("----------");
        //打印1000以内的所有完数
        for (int i = 1; i <= 10000; i++) {
            if (isWanshu(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isWanshu(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
