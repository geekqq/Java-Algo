package Day84;

public class EvenOrOddNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            if (isEven(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isEven(int n) {
        if (n <= 0) return false;
        return (n & 1) == 0;
    }
}
