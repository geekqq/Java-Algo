package Day304;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Day304.PrintMatrix.printMatrix;

public class LC1065IndexPairOfString {

    public static int[][] indexPairs(String text, String[] words) {
        if (words == null || words.length == 0) return null;
        Trie trie = new Trie();
        for (String word : words) {
            Trie cur = trie;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;  // mark there is a word
        }
        // if text is "ababa", check "ababa", "baba". "aba", "ba", "a" individually
        int len = text.length();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Trie cur = trie;
            char cc = text.charAt(i);
            int j = i; // j is moving index
            while (cur.children[cc - 'a'] != null) {
                cur = cur.children[cc - 'a'];
                if (cur.isWord) {
                    list.add(new int[] {i, j});
                }
                j++;
                if (j == len) break;  // the end of the text, we stop here
                else {
                    cc = text.charAt(j);
                }
            }
        }
        // now put all pairs from list into the array
        int size = list.size();
        int[][] res = new int[size][2];
        int i = 0;
        for (int[] r : list) {
            res[i] = r;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "thestoryofleetcodeandme";
        String[] words = {"story","fleet","leetcode"};
        int[][] res = indexPairs(text, words);
        printMatrix(res);
    }
}

class Trie {
    Trie[] children;
    boolean isWord;  // indicate if there is a word
    public Trie() {
        isWord = false;
        children = new Trie[26];
    }
}