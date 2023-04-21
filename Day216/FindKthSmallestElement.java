package Day216;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestElement {

    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int row = matrix.length;
        int col = matrix[0].length;

        PriorityQueue<int[]> q = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });

        boolean[][] visited = new boolean[row][col];

        q.offer(new int[]{0,0});
        int res = 0;

        while (k-- > 0) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            res = matrix[curRow][curCol];

            if (isValid(curRow + 1, curCol, row, col, visited)) {
                q.offer(new int[] {curRow + 1, curCol});
                visited[curRow + 1][curCol] = true;
            }
            if (isValid(curRow, curCol + 1, row, col, visited)) {
                q.offer(new int[] {curRow, curCol + 1});
                visited[curRow][curCol + 1] = true;
            }
        }
        return res;
    }

    private static boolean isValid(int i, int j, int row, int col, boolean[][] visited) {
        return (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j]);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }
}
