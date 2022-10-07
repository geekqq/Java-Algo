package Day36;

public class FindMaxOrMin {
    public static void main(String[] args) {
        //find the max and min value from a given array
        int[] nums = {3,10,5,2,-1,-9,-12};
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
