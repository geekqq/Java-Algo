package Day26;

import java.util.ArrayList;

public class IsPrimeBy6 {
    public static void main(String[] args) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        System.out.println(primeNumbers);
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
