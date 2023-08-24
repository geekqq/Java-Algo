package Day279;

public class IsSubSequence {

    public static boolean isSubSequence(String str, String seq) {
        if (str == null || str.length() == 0 || seq == null || seq.length() == 0 || seq.length() > str.length()) {
            return false;
        }
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
        System.out.println(isSubSequence("abcde", "ace"));
        System.out.println(isSubSequence("abcde", "aec"));
    }
}
