package Day29;

public class FibonacciDemo {
    public static void main(String[] args) {
        //打印输出前10个斐波那契数列中的数字
        //第0个斐波那契数字是0，第1个斐波那契数字是1；
        for (int counter = 0; counter <= 10 ; counter++) {
            System.out.printf("第%d个斐波那契数字是：%d\n", counter, fibonacci(counter));
        }
    }

    public static int fibonacci(int n) {//TODO:long
        if (n < 2) return n;
        else return fibonacci(n -1) + fibonacci(n - 2);
    }
}
