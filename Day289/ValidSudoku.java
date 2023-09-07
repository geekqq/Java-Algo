package Day289;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean validSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(c + " seen in row " + i)
                    || !set.add(c + " seen in column " + j)
                    || !set.add(c + " seen in sub box " + i / 3 +  "-" + j / 3)) return false;
                }
            }
        }
        return true;
    }

    public static boolean validSudokuI(char[][] board) {
        if (board == null || board.length == 0) return false;
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] square = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int cur = board[i][j] - '1'; //char to index
                if (rows[i][cur] || cols[i][cur] || square[i / 3 * 3 + j / 3][cur]) return false;
                rows[i][cur] = true;
                cols[j][cur] = true;
                square[i / 3 * 3 + j / 3][cur] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1 =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(validSudoku(board1));
        System.out.println(validSudokuI(board1));

        char[][] board2 =
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(validSudoku(board2));
        System.out.println(validSudokuI(board2));
    }

}
