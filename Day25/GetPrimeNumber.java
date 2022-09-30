package Day25;

public class GetPrimeNumber {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            if(isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("101到200之间的素数的个数为：" + count);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
