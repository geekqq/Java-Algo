package Day136;

public class IsPrime {
    public static boolean isPrime(int x) {
        if (x <= 3) return x > 1;
        if (x % 6 != 5 && x % 6 != 1) return false;
        for (int i = 5; i * i < x; i += 6) {
            if (x % i == 0 || x % (1 + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 115; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        int count = 0;
        for (int i = 2; i < 3; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
