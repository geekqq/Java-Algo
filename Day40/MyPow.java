package Day40;

public class MyPow {
    public static void main(String[] args) {

        System.out.println(myPow(2,5));
    }
    public static long myPow(int x, int n) {
        //x to the power of n
        if (n <= 0) return 1;
        long half = myPow(x, n/2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
