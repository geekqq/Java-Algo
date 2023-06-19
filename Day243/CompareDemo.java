package Day243;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CompareDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player[] players = new Player[n];
        Checker checker = new Checker();
        for (int i = 0; i < n; i++) {
            players[i] = new Player(sc.next(), sc.nextInt());
        }
        sc.close();
        Arrays.sort(players, checker);
        for (Player player : players) {
            System.out.printf("%s %d\n", player.name, player.score);
        }
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        return p1.score - p2.score == 0 ? p1.name.compareTo(p2.name) : p2.score - p1.score;
    }
}

class Player {
    int score;
    String name;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}