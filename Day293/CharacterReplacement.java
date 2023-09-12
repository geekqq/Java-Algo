package Day293;

public class CharacterReplacement {

    //LC424
    public static int characterReplacement(String s, int k) {
        //cc

        int[] count = new int[26];
        char maxChar = '\0'; // null
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            count[c - 'A']++;
            if (maxChar == '\0' || count[c - 'A'] > count[maxChar - 'A']) {
                maxChar = c;
            }

            while ((end - start + 1) - count[maxChar - 'A'] > k) {
                char startChar = s.charAt(start);
                start++;
                count[startChar - 'A']--;
                if (startChar == maxChar) {
                    for (char ch = 'A'; ch <= 'Z'; ch++) {
                        if (count[ch -'A'] > count[maxChar - 'A']) {
                            maxChar = ch;
                        }
                    }
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
