package Day290;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    public static String encode(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int index = 0;
        while (index < s.length()) {
            int slash = s.indexOf('/', index);
            int size = Integer.valueOf(s.substring(index, slash));
            String word = s.substring(slash + 1, slash + size + 1);
            res.add(word);
            index = slash + size + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"hello", "new", "york!"};
        String msg = encode(strs);
        System.out.println(msg);
        System.out.println(decode(msg));

    }
}
