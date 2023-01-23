package Day142;


import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static final int[][] DIRECTIONS = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    private static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0
        || rooms[0] == null || rooms[0].length == 0) return;

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * cols + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();
            int pRowIndex = p / cols;
            int pColIndex = p % cols;

            for (int[] dir : DIRECTIONS) {
                int ii = pRowIndex + dir[0];
                int jj = pColIndex + dir[1];

                if (ii < 0 || ii >= rows || jj < 0 || jj >= cols
                || rooms[ii][jj] <= rooms[pRowIndex][pColIndex] + 1) {
                    continue;
                }
                rooms[ii][jj] = rooms[pRowIndex][pColIndex] + 1;
                queue.offer(ii * cols + jj);
            }
        }
    }
}
