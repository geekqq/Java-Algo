package Day42;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2,3));
        System.out.println(myPow2(2,4));
    }

    public static long myPow(int x, int n) {
        if(n <= 0) return 1; //不考虑n为负数的情况
        long ans = 1;
        for (int i = 0; i < n; i++) {
           ans *= x;
        }
        return ans;
    }

    public static long myPow2(int x, int n) {
        if (n <= 0) return 1;
        //recursion
        long half = myPow2(x, n/2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
