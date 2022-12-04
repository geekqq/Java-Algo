package Day93;

public class FindDuplicateString {
    public static void main(String[] args) {
        String[] str = {"hello", "jin", "world", "jin", "hi", "hello"};
        findDuplicateString(str);
    }
    public static void findDuplicateString(String[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        for (int i = 0; i < str.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].equals(str[j])) {
                    count ++;
                }
            }
            if (count == 1) {
                System.out.println("The duplicate element is: " + str[i]);
            }
            count = 0;
        }
    }
}
