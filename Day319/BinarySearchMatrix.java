package Day319;

public class BinarySearchMatrix {

    public static boolean binarySearchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols  - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(binarySearchMatrix(matrix, target));
        System.out.println(binarySearchMatrix(matrix, 13));
    }
}
