package Day265;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo2 {

    public static void main(String[] args) {
        List<String> teamA = Arrays.asList("stone", "ray", "gang");
        List<String> teamB = Arrays.asList("hoo", "fei", "jin");
        List<String> teamC = Arrays.asList("leo", "hao", "joy");
        List<List<String>> players = Arrays.asList(teamA, teamB, teamC);

        //before java 8
        for(List<String> team : players) {
            for(String name : team) {
                System.out.print(name + " ");
            }
        }
        System.out.println();
        //java 8 using flatmap

        players.stream().flatMap(t -> t.stream()).forEach(n -> System.out.print(n + " "));
    }
}
