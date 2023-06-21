package Day248;

import java.util.Scanner;

public class LambdaDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println(isOdd(m));
                    break;
                case 2:
                    System.out.println(isPrime(m));
                    break;
                case 3:
                    System.out.println(isPalindrome(m));
                    break;
            }
        }
    }
    private static String isOdd(int n) {
        return (n & 1) == 1 ? "ODD" : "EVEN";
    }
    private static String isPrime(int n) {
        if (n == 2 || n == 3) return "PRIME";
        if (n % 6 != 1 && n % 6 != 5) return "COMPOSITE";
        for (int i = 5; i < Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return "COMPOSITE";
            }
        }
        return "PRIME";
    }

    private static String isPalindrome(int n) {
        String s = String.valueOf(n);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return "NONPALINDROME";
            }
        }
        return "PALINDROME";
    }
}
