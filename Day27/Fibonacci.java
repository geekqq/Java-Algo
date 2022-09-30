package Day27;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.print(a + "\t" + b + "\t");

        for (int i = 0; i < 10 ; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + "\t");
        }
        System.out.println();
        System.out.println("-----------");
        System.out.println(fibonacciOne(3));
        System.out.println("-----------");
        for (int i = 1; i < 13; i++) {
            System.out.print(fibonacciOne(i) + "\t");
        }
    }

    public static int fibonacciOne(int n) {
        if ( n < 2) {
            return n ;
        } else {
            return fibonacciOne(n - 1) + fibonacciOne(n - 2);
        }
    }

}
