package Day25;

public class PrintDiamond {
    public static void main(String[] args) {
        printDiamond(9);
    }

    public static void printDiamond(int n) {
        int mid = n >> 1;
        int range = 0;
        for (int i = 0; i < n; i++) {
            if (i <= mid) {
                range = i;
            } else {
                range = n - 1 - i;
            }
            for (int j = 0; j < n; j++) {
                if (j >= mid - range && j <= mid + range) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
