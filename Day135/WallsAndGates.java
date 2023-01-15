package Day135;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        int row = rooms.length;
        int col = rooms[0].length;

        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * col + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();
            int pRowIndex = p / col;
            int pColIndex = p % col;
            for (int[] d : directions) {
                int x = pRowIndex + d[0];
                int y = pColIndex + d[1];
                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length
                        || rooms[x][y] <= rooms[pColIndex][pRowIndex] + 1) {
                    continue;
                }
                rooms[x][y] = rooms[pRowIndex][pColIndex] + 1;
                queue.offer(x * col + y);
            }
        }
    }
}
