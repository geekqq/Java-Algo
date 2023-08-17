package Day273;

import java.util.Random;

public class NumberOfIslands {

    public static int getIslandNum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int numIslands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row, col - 1, visited); // go left
        dfs(grid, row - 1, col, visited); // go up
        dfs(grid, row, col + 1, visited); // go right
        dfs(grid, row + 1, col, visited);
    }

    public static int[][] generateBinaryGrid(int row, int col) {
        Random rd = new Random();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = rd.nextInt(2);
                matrix[i][j] = num;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateBinaryGrid(5, 6);
        printMatrix(matrix);
        System.out.println(getIslandNum(matrix));
    }
}
