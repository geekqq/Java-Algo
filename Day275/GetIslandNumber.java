package Day275;

import java.util.Random;

public class GetIslandNumber {

    public static int getIslandNum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
        || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row, col - 1, visited); // go left
        dfs(grid, row - 1, col, visited); // go up
        dfs(grid, row, col + 1, visited); // go right
        dfs(grid, row + 1, col, visited); //go down
    }

    public static int[][] generateBinaryGrid(int row, int col) {
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
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = generateBinaryGrid(5, 8);
        printMatrix(grid);
        System.out.println("----get num of islands----");
        System.out.println(getIslandNum(grid));
    }
}
