package Day241;

public class GetSmallestAndLargest {

    public static String getSmallestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return null;
        String smallest = s.substring(0, k);
        for (int i = 1; i < s.length() - k + 1; i++) {
            String temp = s.substring(i, i + k);
            if (smallest.compareTo(temp) > 0 ) {
                smallest = temp;
            }
        }
        return smallest;
    }

    public static String getLargestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return null;
        String largest = s.substring(0, k);
        for (int i = 1; i < s.length() - k + 1; i++) {
            String temp = s.substring(i, i + k);
            if (largest.compareTo(temp) < 0) {
                largest = temp;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestSubstring("welcometojava", 3));
        System.out.println(getLargestSubstring("welcometojava", 3));
    }
}
