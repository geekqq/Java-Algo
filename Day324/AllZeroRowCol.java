package Day324;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AllZeroRowCol {
    
    public static List<List<Integer>> allZero(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        List<Integer> rowRes = new ArrayList<>();
        List<Integer> colRes = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            boolean allZero = true;
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '+') {
                    allZero = false;
                }
            }
            if (allZero) rowRes.add(i);
        }
        for (int i = 0; i < col; i++) {
            boolean allZero = true;
            for (int j = 0; j < row; j++) {
                if (board[j][i] == '+') {
                    allZero = false;
                }
            }
            if (allZero) colRes.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(rowRes);
        res.add(colRes);
        return res;
    }

    public static char[][] generateRandomMatrix(int row, int col) {
        char[] chars = new char[]{'+', '0'};
        Random rd = new Random();
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = rd.nextInt(2);
                char c = chars[index];
                matrix[i][j] = c;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        char[][] matrix = generateRandomMatrix(4,6);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(allZero(matrix));
    }
}
