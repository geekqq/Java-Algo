package Day288;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        //cc
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                if (!set.add(cur + " found in row " + i)
                || !set.add(cur + " found in column " + j)
            || !set.add(cur + " found in sub box " + i / 3 + "-" + j / 3)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
