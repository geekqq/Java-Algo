package Day37;

import java.util.Arrays;

public class ExtendingArray {
    //数组扩容
    public static void main(String[] args) {
        String[] array = {"A", "B", "C"};
        String[] extended = new String[6];
        extended[3] = "E";
        extended[4] = "F";
        System.arraycopy(array, 0, extended, 0, array.length);
        System.out.println(Arrays.toString(extended));
    }
}
