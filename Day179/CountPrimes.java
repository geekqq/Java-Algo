package Day179;

import java.util.Arrays;

public class CountPrimes {
    private static int countPrimes(int x) {
        boolean[] isPrime = new boolean[x];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < x; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < x; j+=i) {
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

    public static void main(String[] args) {
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(10000));
    }
}
