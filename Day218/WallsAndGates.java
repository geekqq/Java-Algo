package Day218;

import java.util.LinkedList;
import java.util.Queue;

import static Day160.WallsAndGates.DIRECTIONS;

public class WallsAndGates {

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0
                || rooms[0] == null || rooms[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(i * col + j);
                }
            }
        }
        int minLen = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int p = q.poll();
                int pRowIndex = p / col;
                int pColIndex = p % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = pRowIndex + dir[0];
                    int jj = pColIndex + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col
                            && rooms[ii][jj] == Integer.MAX_VALUE) {
                        rooms[ii][jj] = minLen;
                        q.offer(ii * col + jj);
                    }
                }
            }
            minLen++;
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}