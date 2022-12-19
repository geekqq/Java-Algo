package Day108;

public class IsEvenNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 111; i++) {
            if (isEven(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static boolean  isEven(int n) {
        return (n & 1) == 0;
    }
}
