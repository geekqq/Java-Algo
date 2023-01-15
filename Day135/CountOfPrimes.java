package Day135;

import java.util.Arrays;

public class CountOfPrimes {
    public static int countPrimes(int n) {
        //输出小于n的所有质数的个数
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 每个质数的倍数都不是质数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
