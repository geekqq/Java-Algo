package Day16;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.printf("%d x %d = %d\t", j, i, i*j);
            }
            System.out.println();
        }
    }
}
