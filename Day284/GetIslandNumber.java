package Day284;

import java.util.Random;

public class GetIslandNumber {

    public static int getIsland(int[][] grid) {
        if (grid == null || grid.length == 0
        || grid[0] == null || grid[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
        && grid[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            dfs(grid, row, col - 1, visited);
            dfs(grid, row - 1, col, visited);
            dfs(grid, row, col + 1, visited);
            dfs(grid, row + 1, col, visited);
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
        int[][] grid = generateBinaryGrid(5,7);
        printGrid(grid);
        System.out.println();
        System.out.println(getIsland(grid));
    }
}
