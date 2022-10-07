package Day36;

public class DemoMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,5,2,0},
                {2,3,4,6},
                {9,4,6,1},
                {0,5,6,7},
        };
        setZeroesInMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] setZeroesInMatrix(int[][] matrix) {
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return null;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
