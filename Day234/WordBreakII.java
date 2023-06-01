package Day234;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        boolean[] mem = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < mem.length; i++) {
            mem[i] = true;
        }
        for (String str: wordDict) {
            set.add(str);
        }

        dfs(s, set, res, new StringBuilder(), 0, mem);
        return res;
    }

    private static void dfs(String s, Set<String> set, List<String> res, StringBuilder sb, int index, boolean[] mem) {
        if (index == s.length()) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        int size = res.size();

        for (int i = index + 1; i <=  s.length(); i++) {
            String word = s.substring(index, i);

            if (set.contains(word) && mem[i]) {
                int len = sb.length();
                sb.append(word);
                sb.append(" ");
                dfs(s, set, res, sb, i, mem);
                sb.setLength(len);
            }
        }

        if (res.size() == size) {
            mem[index] = false;
        }
    }
}
