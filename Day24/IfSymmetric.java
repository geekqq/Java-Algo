package Day24;

public class IfSymmetric {
    public static void main(String[] args) {
        String s = "xXxx";
        System.out.println(ifSymmetric(s) ? "是回文字符串" : "不是回文字符串");
    }

    public static boolean ifSymmetric(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
