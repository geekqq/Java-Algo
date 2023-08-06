package Day266;

public class SearchMatrix {

    public static void search(int[][] matrix, int n, int key) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == key) {
                System.out.println("Key found at index of " + i + ", " + j);
                return;
            } else if (matrix[i][j] < key) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("The key is not found in the matrix!");
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        search(matrix, matrix.length, 51);
    }
}
