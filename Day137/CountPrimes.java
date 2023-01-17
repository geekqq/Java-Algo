package Day137;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes2(10000));
    }

    private static int countPrimes(int x) {

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
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int x) {
        if (x <= 3) return x > 1;
        if (x % 6 != 5 && x % 6 != 1) return false;
        for (int i = 5; i * i < x; i += 6) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            }
        }
        return true;
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
}
