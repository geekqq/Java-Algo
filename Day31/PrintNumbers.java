package Day31;

public class PrintNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            if (i % 10 == 3 || i % 10 == 5 || i % 10 == 7) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
