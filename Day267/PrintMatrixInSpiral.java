package Day267;

public class PrintMatrixInSpiral {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };
        int[][] matrix1 = {
                {1},
                {2},
                {2},
                {4}
        };
        int[][] matrix2 = {
                {1,2,3,4}
        };
        printMatrixSpiral(matrix);
        printMatrixSpiral(matrix1);
        printMatrixSpiral(matrix2);
    }

    public static void printMatrixSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
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
        System.out.println();
    }
}
