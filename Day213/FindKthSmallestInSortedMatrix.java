package Day213;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            return Integer.MAX_VALUE;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });

        boolean[][] visited = new boolean[row][col];

        queue.offer(new int[]{0,0});
        int res = 0;
        while (k-- > 0) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            res = matrix[curRow][curCol];
            if (isValid((curRow + 1), curCol, row, col, visited)) {
                queue.offer(new int[]{curRow + 1, curCol});
                visited[curRow + 1][curCol] = true;
            }
            if (isValid(curRow, (curCol + 1), row, col, visited)) {
                queue.offer(new int[]{curRow, curCol + 1});
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
            {0,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        System.out.println(findKthSmallest(matrix, 10));
    }
}
