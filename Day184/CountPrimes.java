package Day184;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(10000));
    }

    public static int countPrimes(int x) {
        boolean[] isPrime = new boolean[x];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < x; i++) {
            if (isPrime[i]) {
                for (int j = i *i; j < x; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < x; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {

        if (n <= 3) return n > 1;
        if (n % 6 != 1 && n % 6 != 5) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
