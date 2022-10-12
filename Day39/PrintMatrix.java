package Day39;

public class PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = printMatrix(10);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] printMatrix(int n) {
        //print a 2d matrix n rows, 1st row has 0 0, 2nd row has 1 0,... the n rows has n-1 0s
        //corner cases
        if (n == 0) return null;
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[i];
        }
        return matrix;
    }
}
