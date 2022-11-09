package Day69;

public class EvenNumber {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (isEvenNum(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static boolean isEvenNum(int n) {
        if ((n & 1) == 0 ) {
            return true;
        }
        return false;
    }
}
