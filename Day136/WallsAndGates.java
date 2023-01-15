package Day136;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0
        || rooms[0] == null || rooms[0].length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        int[][] directions = {{0,1},{0,-1},{1,0},{1,-1}};

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

            for (int[] dir : directions) {
                int i = pRowIndex + dir[0];
                int j = pColIndex + dir[1];

                if (i < 0 || i >= rows || j < 0 || j >= cols
                || rooms[i][j] <= rooms[pRowIndex][pColIndex] + 1) {
                    continue;
                }
                rooms[i][j] = rooms[pRowIndex][pColIndex] + 1;
                queue.offer(i * cols + j);
            }
        }
    }

}
