package Day266;

public class SpiralPrintMatrix {

    public static void spiralPrintMatrix(int[][] matrix, int row, int col) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) return;

        int k = 0;
        int l = 0;
        while (k < row && l < col) {
            for (int i = l; i < col; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            for (int i = k; i < row; i++) {
                System.out.print(matrix[i][col - 1] + " ");
            }
            col--;
            if (k < row) {
                for (int i = col - 1; i >= l; i--) {
                    System.out.print(matrix[row - 1][i] + " ");
                }
                row--;
            }

            if (l < col) {
                for (int i = row - 1; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };
        spiralPrintMatrix(matrix, matrix.length, matrix[0].length);
    }
}
