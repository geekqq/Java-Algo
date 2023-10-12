package Day321;

public class BinarySearchMatrix {

    public static boolean binarySearchMatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == k) return true;
            else if (matrix[i][j] > k) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == k) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(binarySearchMatrix(matrix, target));
        System.out.println(binarySearchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix(matrix, 13));
    }
}
