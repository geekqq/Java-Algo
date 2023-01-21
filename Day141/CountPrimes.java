package Day141;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(isPrime(2));
    }

    private static int isPrime(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < Math.sqrt(n); i++){
            if (isPrime[i]) {
                for (int j = i * i; j <n; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
