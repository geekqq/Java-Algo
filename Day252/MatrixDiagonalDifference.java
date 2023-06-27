package Day252;

public class MatrixDiagonalDifference {

    public static int diagonalDiff(int[][] matrix) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int leftToRight = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            leftToRight += matrix[i][i];
        }
        int rightToLeft = 0;
        for (int i = 0; i < n; i++) {
            rightToLeft += matrix[i][n - 1 - i];
        }
        return Math.abs(leftToRight - rightToLeft);
    }
}
