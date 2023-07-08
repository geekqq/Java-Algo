package Day255;

import java.util.ArrayList;
import java.util.List;

public class MainDemo {

    public static void main(String[] args) {
        List<String> strings = new ArrayList();

        strings.add("Hello");
        strings.add("World");

        String hello = strings.get(0);
        String world = strings.get(1);
        System.out.println(hello + " " + world);
    }
}
