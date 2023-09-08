package Day289;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + 1 + size));
            i = slash + 1 + size;
        }
        return res;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = Arrays.asList("Hello", "World");
        String msg = codec.encode(strs);
        System.out.println(msg);
        System.out.println(codec.decode(msg));
    }
}
