package Day134;

public class IsPrime {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 500000; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isPrime(int x) {
        if (x <= 3) {
            return x > 1;
        }
        if (x % 6 != 5 && x % 6 != 1) return false;
        for (int i = 5; i <= Math.sqrt(x) ; i += 6) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
