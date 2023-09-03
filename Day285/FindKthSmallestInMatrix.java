package Day285;

import java.util.PriorityQueue;

public class FindKthSmallestInMatrix {



    public static int findKthSmallestInMatrix(int[][] matrix, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        int n = matrix.length;
        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(new Node(matrix[i][0], i, 0));
        }
        Node cur = null;
        while (k-- > 0) {
            cur = pq.poll();
            int row = cur.row;
            int col = cur.col;

            if (col < n - 1) {
                pq.offer(new Node(matrix[row][col + 1], row, col + 1));
            }
        }
        return cur.val;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] matrix2 = {{-5}};
        int[][] matrix3 = {{1, 2}, {1, 3}};
        System.out.println(findKthSmallestInMatrix(matrix, 8));
        System.out.println(findKthSmallestInMatrix(matrix2, 1));
        System.out.println(findKthSmallestInMatrix(matrix3, 3));
    }
}

class Node {
    int row;
    int col;
    int val;

    public Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}