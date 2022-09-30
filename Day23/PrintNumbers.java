package Day23;

public class PrintNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int y = i % 10;
            if (y == 1 || y == 5 || y == 7) {
                System.out.println(i);
            }
        }
    }
}
