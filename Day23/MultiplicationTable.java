package Day23;

public class MultiplicationTable {
    public static void main(String[] args) {
        outer:
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i + 1 ; j++) {
                System.out.printf("%d x %d = %d\t", j, i, j*i);
                if (j == 5 && i == 3) {
                    break outer;
                }
            }
            System.out.println();
        }
    }
}
