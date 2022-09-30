package Day00;

public class DemoRecursion {
    public static int sum(int n) {
        return n > 0 ? n + sum(n - 1): 0;
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}
