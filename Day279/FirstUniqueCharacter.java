package Day279;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static int firstUniqueCharacter(String str) {
        if (str == null || str.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueCharacter("codeforcode"));
        System.out.println(firstUniqueCharacter("racecars"));
    }
}
