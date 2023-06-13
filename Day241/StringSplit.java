package Day241;

public class StringSplit {
    public static void main(String[] args) {
        // [ !,?.\_'@] match all the special characters
        String s = "He is a very very good boy, isn't he?";
        String regex = "[^A-Za-z]+";
        String[] strs = s.split(regex);
        System.out.println(strs.length);
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
