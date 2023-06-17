package Day243;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LeapGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int leap = sc.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = sc.nextInt();
            }
            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }
        sc.close();
    }

    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0, new HashSet<Integer>());
    }
    private static boolean canWin(int leap, int[] game, int i, Set<Integer> visited) {
        if (visited.contains(i)) return  false;
        visited.add(i);
        if (i >= game.length) return true;
        if (i < 0 || game[i] == 1) return false;
        return canWin(leap, game, i + leap, visited) ||
                canWin(leap, game, i + 1, visited) ||
                canWin(leap, game, i - 1, visited);
    }
}
