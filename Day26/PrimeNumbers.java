package Day26;

import java.util.ArrayList;

public class PrimeNumbers {
    public static void main(String[] args) {
        //求输出第k个素数
        int count = 0;
        int k = 10;

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 1; ; i++) {
            if (isPrime(i)) {
                primes.add(i);
                count++;
                if (count == k) {
                    System.out.println(i);
                    break;
                }
            }
        }
        System.out.println(primes);
    }

    public static boolean isPrime(int n) {
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
