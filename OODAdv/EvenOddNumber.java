package OODAdv;

public class EvenOddNumber {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (isEven(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 1; i <= 100; i++) {
            if (isOdd(i)) {
                System.out.print(i + " ");
            }
        }
    }


    public static boolean isEven(int n) {
        if ((n & 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isOdd(int n) {
        if ((n & 1) == 1) {
            return true;
        }
        return false;
    }
}
