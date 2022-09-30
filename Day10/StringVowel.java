package Day10;

public class StringVowel {
    public static void main(String[] args) {
        String str = "codesignal";
        String vowel = "aeiou";
        int n = str.length();
        char[] chars = str.toCharArray();
        int index = -1;
        char c = '0';
        for (int i = 0; i < n; i++) {
            if (vowel.indexOf(str.charAt(i)) != -1) {
                if (index == -1) {
                    index = i;
                    c = str.charAt(i);
                    continue;
                }
                chars[i] = c;
                c = str.charAt(i);
            }
        }
        chars[index] = c;
        StringBuilder sb = new StringBuilder();
        for (Character a : chars) {
            sb.append(a);
        }
        System.out.println(sb.toString());
    }
}
