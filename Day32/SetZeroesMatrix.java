package Day32;

import java.util.Arrays;

public class SetZeroesMatrix {

    //M x N 的矩阵中如果某个元素为0，则将其所在的行与列清零；
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1},
                };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static int[][] setZeroes(int[][] matrix) {
        int n = matrix.length;  //row
        int m = matrix[0].length; //列 cols
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

}
