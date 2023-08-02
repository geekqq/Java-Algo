package Day264;

import java.util.ArrayList;
import java.util.List;

public class PrintAscII {

    public static void main(String[] args) {
        List<Character> characterList = new ArrayList<>();
        Character c = ' ';
        for (int i = 32; i < 128; i++) {
            characterList.add(c);
            c++;
        }
        for (Character x : characterList) {
            System.out.print(x);
        }
        System.out.println();
        System.out.println("================================================================================");
        Character x = ' ';
        for (int i = 32; i < 128; i++) {
            System.out.print(x++);

        }
    }
}
