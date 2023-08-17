package Day274;

import java.util.Random;

public class GetIslandNumber {

    public static int getIslandNumber(int[][] matrix) {
        int m = matrix.length;;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    dfs(matrix, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length
        || visited[row][col] || matrix[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        dfs(matrix, row, col - 1, visited); // go left;
        dfs(matrix, row - 1, col, visited); // go up;
        dfs(matrix, row, col + 1, visited); //go right;
        dfs(matrix, row + 1, col, visited); // go down;
    }

    public static int[][] generateBinaryMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Random rd = new Random();
                matrix[i][j] = rd.nextInt(2);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateBinaryMatrix(4,6);
        printMatrix(matrix);
        System.out.println(getIslandNumber(matrix));
    }
}
