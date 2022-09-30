package Day01;
import java.util.Arrays;

public class DemoStringArray {
    public static void main(String[] args) {
        String[][] s = new String[2][];
        s[0] = new String[3];
        s[1] = new String[3];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1][0] = new String("To");
        s[1][1] = new String("You");
        s[1][2] = new String("!");
        System.out.println(Arrays.deepToString(s));
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.println(s[i][j]);

            }

        }
    }

}
