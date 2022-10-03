package Day32;

public class IsPrime {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            if(isPrime(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("100以内的质数的个数为：" + count);
    }

    public static boolean isPrime(int n) {
        if ( n <= 3) return n > 1;
        if (n % 6 != 1 && n % 6 != 5) return false;
        for (int i = 5; i <= Math.sqrt(n) ; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
