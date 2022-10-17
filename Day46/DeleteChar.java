package Day46;

public class DeleteChar {
    public static void main(String[] args) {
        System.out.println(deleteCharFromString("jinwei",4));
    }
    public static String deleteCharFromString(String s, int n) {
        //int n is the index of the char to be deleted
        return s.substring(0, n) + s.substring(n + 1);
    }
}
