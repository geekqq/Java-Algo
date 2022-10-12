package Day40;

public class PrintTriangleMatrix {
    public static void main(String[] args) {
        int[][] matrix = printTriangleMatrix(10);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] printTriangleMatrix(int n) {
        if (n <= 0) return null;
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[i];
        }
        return matrix;
    }
}
