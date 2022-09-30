package Day24;

public class isPrime {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
        //求 100 以内的质数总和
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2 ; i <= n/2 ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
