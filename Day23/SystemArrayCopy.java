package Day23;

import java.util.Arrays;

public class SystemArrayCopy {
    public static void main(String[] args) {
        int[] s = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] d = {15, 25, 35, 45, 55, 65, 75, 85, 95, 105};

        int sourcePos = 3;
        int destPos = 5;
        int length = 4;

        //print the source array elements
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println();

        //print the destination array elements
        for (int num : d) {
            System.out.println(num);
        }
        System.out.println();

        //Use System.arraycopy() method
        System.arraycopy(s, sourcePos, d, destPos, length);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(d));
    }
}
