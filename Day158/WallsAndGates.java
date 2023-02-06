package Day158;


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
        ||rooms[0] == null || rooms[0].length == 0) {
            throw new IllegalArgumentException();
        }
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
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int p = queue.poll();
                int pRow = p / cols;
                int pCol = p % cols;
                for (int[] dir : DIRECTIONS) {
                    int ii = pRow + dir[0];
                    int jj = pCol + dir[1];
                    if (ii >= 0 && ii < rows && jj >= 0 && jj < cols
                    && rooms[ii][jj] == Integer.MAX_VALUE) {
                        rooms[ii][jj] = minLen;
                        queue.offer(ii * cols + jj);
                    }
                }
            }
            minLen++;
        }
    }
}
