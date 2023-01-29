package Day149;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(countPrimes(1000000));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        long begin1 = System.currentTimeMillis();
        System.out.println(countPrimes2(1000000));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - begin1);
    }

    private static int countPrimes(int x) {
        if (x < 2) return 0;
        boolean[] isPrime = new boolean[x];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < x; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < x; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < x; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    private static int countPrimes2(int x) {
        int count = 0;
        for (int i = 2; i < x; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 3) return n > 1;
        if (n % 6 != 5 && n % 6 != 1) return false;
        for (int i = 5; i <= Math.sqrt(n) ; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
