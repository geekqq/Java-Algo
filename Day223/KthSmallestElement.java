package Day223;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int kthSmallestInMatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
                {1,2,3},
                {3,4,5},
                {5,6,7}
        };
        System.out.println(kthSmallestInMatrix(matrix,4));
    }
}
