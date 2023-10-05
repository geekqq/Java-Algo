package Day315;

import static Day298.IslandNumber.generateBinaryGrid;
import static Day298.IslandNumber.printGrid;

public class GetIslandsNumber {

    public static int getIslands(int[][] grid) {
        if (grid == null || grid.length == 0
        || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
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

    public static void main(String[] args) {
        int[][] grid = generateBinaryGrid(5,7);
        printGrid(grid);
        System.out.println();
        System.out.println(getIslands(grid));
    }
}
