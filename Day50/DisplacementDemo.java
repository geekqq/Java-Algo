package Day50;

public class DisplacementDemo {
    public static void main(String[] args) {
        int n = 20;
        n = n >> 1;
        System.out.println(n);
        n = n >> 1;
        System.out.println(n);
        int m = 10;
        m = m << 1;
        System.out.println(m);
        m = m << 1;
        System.out.println(m);
        m = m << 3;
        System.out.println(m);
    }
}
