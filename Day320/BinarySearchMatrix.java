package Day320;

public class BinarySearchMatrix {

    public static boolean binarySearchMatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == k) return true;
            else if (matrix[i][j] < k) left = mid + 1;
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
