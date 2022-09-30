package Day25;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintNums {
    public static void main(String[] args) {
        //打印100以内尾数为3，5，7的数字
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (i % 10 == 3 || i % 10 == 5 || i % 10 == 7) {
                nums.add(i);
            }
        }
        System.out.println(nums);

        ArrayList<Integer> nums2 = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (i % 10 == 3 || i % 10 == 5 || i % 10 == 7) {
                continue;
            }
            nums2.add(i);
        }
        System.out.println(nums2);
    }
}
