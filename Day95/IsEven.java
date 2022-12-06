package Day95;

public class IsEven {
    public static void main(String[] args) {
        for (int i = 0; i < 22; i++) {
            if (isEven(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
