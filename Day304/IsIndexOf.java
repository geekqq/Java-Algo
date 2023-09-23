package Day304;

public class IsIndexOf {

    public static int indexOf(String s, String t) {
        if (s == null || t == null) return -1;
        int l1 = s.length();
        int l2 = t.length();
        if (l1 < l2) return indexOf(t, s);
        for (int i = 0; i <= l1 - l2; i++) {
            boolean subString = true;
            for (int j = 0; j < l2; j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    subString = false;
                    break;
                }
            }
            if (subString) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("stonehoo", "hoo"));
    }
}
