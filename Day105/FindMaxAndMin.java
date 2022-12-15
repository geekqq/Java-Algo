package Day105;

import java.util.Arrays;

public class FindMaxAndMin {
    public static void main(String[] args) {
        int[] nums = {20,20,40,30,-10,30,50,40};
        System.out.println(Arrays.stream(nums).max().getAsInt());
        System.out.println(Arrays.stream(nums).max());
        System.out.println(Arrays.stream(nums).min().getAsInt());
        System.out.println(Arrays.stream(nums).min());

    }
}
