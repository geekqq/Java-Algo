package Day280;

import java.util.ArrayList;
import java.util.List;

public class AllSubString {

    public static void allSubString(String s) {
        if (s == null || s.length() == 0) return;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length() ; j++) {
                System.out.print(s.substring(i, j) + " ");
            }
        }
    }
    public static List<String> allSubStringList(String s) {
        if (s == null || s.length() == 0) return null;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                list.add(s.substring(i, j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        allSubString("absdsa");
        System.out.println();
        System.out.println(allSubStringList("abcdes"));
    }
}
