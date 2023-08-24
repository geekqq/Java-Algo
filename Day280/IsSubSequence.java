package Day280;

import org.w3c.dom.ls.LSOutput;

public class IsSubSequence {

    public static boolean isSubSequence(String str, String seq) {
        //cc

        int i = 0;
        int j = 0;
        while (i < str.length() && j < seq.length()) {
            if (str.charAt(i) == seq.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == seq.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubSequence("abcde", "aced"));
    }
}
