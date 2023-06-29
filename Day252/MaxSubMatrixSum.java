package Day252;

public class MaxSubMatrixSum {

    private static int[][] calculatePrefixSum(int[][] matrix, int size) {
        int [][] prefixSum = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                prefixSum[i][j] = matrix[i][j];
                if (i > 0) prefixSum[i][j] += prefixSum[i - 1][j];
                if (j > 0) prefixSum[i][j] += prefixSum[i][j - 1];
                if (i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i - 1][j - 1];
            }
        }
        return prefixSum;
    }

    public static int getMaxSubMatrixSum(int[][] matrix, int n) {
        int size = 2 * n;
        int[][] prefixSum = calculatePrefixSum(matrix, size);
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = i; k < size; k++) {
                    for (int l = j; l < size; l++) {
                        int sum = prefixSum[k][l];
                        if (i > 0) sum -= prefixSum[i - 1][l];
                        if (j > 0) sum -= prefixSum[k][j - 1];
                        if (i > 0 && j > 0) sum += prefixSum[i - 1][j - 1];

                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int n = 2;
        int masSum = getMaxSubMatrixSum(matrix, n);
        System.out.println(masSum);
    }
}
