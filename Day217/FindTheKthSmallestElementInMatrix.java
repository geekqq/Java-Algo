package Day217;

import java.util.PriorityQueue;

public class FindTheKthSmallestElementInMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        System.out.println(findKthSmallest(matrix, 8));
    }
}
