package Day10;

public class ReverseString {
    public static void main(String[] args) {
        String s = "CodeSignal";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
