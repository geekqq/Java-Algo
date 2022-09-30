package Day24;

public class NoDuplicatedNum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((i != j) && (j != k) && (k != i)) {
                        System.out.println(nums[i] * 100 + nums[j] * 10 + nums[k]);
                        count++;
                    }
                }
            }
        }
        System.out.println("一共有" + count + "种没有重复数字的三位数");
    }
}
