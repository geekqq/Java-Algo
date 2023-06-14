package Day242;

public class AddII {

    public static void add(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            System.out.print(i < a.length - 1 ? a[i] + "+" : a[i] + "=");
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        add();
    }
}
