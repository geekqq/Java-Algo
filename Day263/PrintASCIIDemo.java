package Day263;

import java.util.ArrayList;
import java.util.List;

public class PrintASCIIDemo {

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        Character c = ' ';
        for (int i = 32; i < 128; i++) {
            list.add(c);
            c++;
        }
        System.out.println(list);
        for (char x : list) {
            System.out.print(x);
        }
        System.out.println();
    }
}
