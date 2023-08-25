package Day256;

public class PrintStringArray {
    public static void printStringArray(String[] arr) {
        int n = arr.length;

        for (int i = 0; i <= 6*n; i++) {
            System.out.print("-");
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.format("|  %2s  ", i);
        }
        System.out.println("|");
        for (int i = 0; i <= 6*n; i++) {
            System.out.print("-");
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.format("|  %2s  ", arr[i]);
        }
        System.out.println("|");
        for (int i = 0; i <= 6*n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
