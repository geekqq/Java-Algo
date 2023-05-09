package Day225;

public class SingleNumberII {

    //LC137
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int digitSum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    digitSum++;
                    //filter out the digits that belogn to the num that appear 3 times
                    digitSum %= 3;
                }
            }
            //Assign the digit back to the number which appears only one time
            if (digitSum != 0) {
                answer |= digitSum << i;
            }
        }
        return answer;
    }
}
