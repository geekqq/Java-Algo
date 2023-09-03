package Day286;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestMatrix {

    public static int findKthSmallestElementMatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
                ||matrix[0] == null || matrix[0].length == 0) throw new IllegalArgumentException("invalid input");

        Queue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        int n = matrix.length;
        for (int i = 0; i < Math.min(k, n); i++) {
            heap.offer(new Node(matrix[i][0], i, 0));
        }
        Node cur = null;
        while (k-- > 0) {
            cur = heap.poll();
            int row = cur.row;
            int col = cur.col;
            if (col < n - 1) {
                heap.offer(new Node(matrix[row][col + 1], row, col + 1));
            }
        }
        return cur.val;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] matrix2 = {{-5}};
        int[][] matrix3 = {{1, 2}, {1, 3}};
        System.out.println((findKthSmallestElementMatrix(matrix, 9)));
        System.out.println(findKthSmallestElementMatrix(matrix2, 1));
        System.out.println(findKthSmallestElementMatrix(matrix3, 3));
    }

}


class Node {
    int val;
    int row;
    int col;

    public Node(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}