package Day41;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static int myPow(int x, int n) { //TODO: long
        if (n == 0) return 1;  //这里不考虑n是负数的情况

        int half = myPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
