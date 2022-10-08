package Day36;

public class FindMaxOrMin {
    public static void main(String[] args) {
        //find the max and min value from a given array
        int[] nums = {3,10,-5,-2,1,9,12};
        //this is not correct because if all the elements are smaller than 0
        //or all the elements are bigger than 0
        //so min and max should equals to nums[0] when declared
        int max = nums[0];
        int min = nums[0];
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
