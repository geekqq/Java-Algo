package Day295;

import java.util.Random;

public class GetIslandNumber {

    public static int getIslandNumber(int[][] matrix) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    dfs(matrix, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
        && matrix[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            dfs(matrix, row, col - 1, visited);
            dfs(matrix, row - 1, col, visited);
            dfs(matrix, row, col + 1, visited);
            dfs(matrix, row + 1, col, visited);
        }
    }

    public static int[][] generateBinaryGrid(int row, int col) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Random rd = new Random();
                grid[i][j] = rd.nextInt(2);
            }
        }
        return grid;
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = generateBinaryGrid(5, 7);
        printGrid(grid);
        System.out.println();
        System.out.println(getIslandNumber(grid));
    }
}
