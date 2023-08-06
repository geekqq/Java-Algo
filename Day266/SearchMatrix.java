package Day266;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static void printMatrixSpiral(int[][] maxtrix, int row, int col) {
        if (maxtrix == null || maxtrix.length == 0
        || maxtrix[0] == null || maxtrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int k = 0;
        int l = 0;
        while (k < row && l < col) {
            for (int i = l; i < col; i++) {
                System.out.print(maxtrix[k][i] + " ");
            }
            k++;
            for (int i = k; i < row; i++) {
                System.out.print(maxtrix[i][col - 1] + " ");
            }
            col--;
            if (k < row) {
                for (int i = col - 1; i >= l ; i--) {
                    System.out.print(maxtrix[row - 1][i] + " ");
                }
                row--;
            }

            if (l < col) {
                for (int i = row - 1; i >= k ; i--) {
                    System.out.print(maxtrix[i][l] + " ");
                }
                l++;
            }
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] seen = new boolean[row][col];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int di = 0;

        for (int i = 0; i < row * col; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];
            if (0 <= cr && cr < row && 0 <= cc && cc < col && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        for (Integer integer : ans) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        search(matrix, matrix.length, 51);
        printMatrixSpiral(matrix, 4, 4);
        printMatrix(matrix);

        int[][] matrix1 = {
                {10},
                {5},
                {15}
        };

        printMatrixSpiral(matrix1, 3, 1);
        printMatrix(matrix1);
    }



}
