package Day25;

import java.util.ArrayList;
import java.util.Arrays;

public class GetPrimeNumber2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num = 101; num < 201 ; num++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(num) ; j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nums.add(num);
            }
        }
        System.out.println(nums);
        System.out.println(nums.size());
    }
}
