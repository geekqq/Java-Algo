package Day165;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " x " + j + " = " + i * j + "\t\t");
            }
            System.out.println();
        }
    }
}
