package Day27;

import java.util.ArrayList;

public class PrimeChecker {
    public static void main(String[] args) {
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (ifPrime(i)) {
                prime.add(i);
            }
        }
        System.out.println(prime);
    }

    public static boolean ifPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }

        if (n % 6 != 5 && n % 6 != 1) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n) ; i += 6) {
            if (n % i == 0 || n % (i + 2) ==0) {
                return false;
            }
        }
        return true;
    }
}
