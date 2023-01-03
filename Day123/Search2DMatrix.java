package Day123;

import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 0;
        System.out.println(Arrays.toString(searchMatrix(matrix, target)));
    }
    public static int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rowIndex = mid / cols;
            int colIndex = mid % cols;
            int temp = matrix[rowIndex][colIndex];
            if (temp == target) {
                return new int[] {rowIndex, colIndex};
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
