package Day224;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;

        int answer = 0;

        for (int i = 0; i < 32; i++) {
            int digitSum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    digitSum++;
                    // filter out the digits that belong to the num that appears 3 times
                    digitSum %= 3;
                }
            }
            //assign the digit back to the number appearing only once
            if (digitSum != 0) {
                answer |= digitSum << i;
            }
        }
        return answer;
    }
}
