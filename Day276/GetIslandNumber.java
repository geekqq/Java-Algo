package Day276;

import java.util.Random;

public class GetIslandNumber {

    public static int getIslands(int[][] grid) {
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
        || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs(grid, row, col - 1, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row + 1, col, visited);
    }

    public static int[][] generateMatrix(int row, int col) {

        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Random rd = new Random();
                grid[i][j] = rd.nextInt(2);
            }
        }
        return grid;
    }

    public static void printMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = generateMatrix(5,6);
        printMatrix(grid);
        System.out.println(getIslands(grid));
    }
}
