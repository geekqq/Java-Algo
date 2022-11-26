package Day86;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t", j, i, i * j);
            }
            System.out.println();
        }
    }
}
