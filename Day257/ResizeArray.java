package Day257;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class ResizeArray {

    public static int[] resize(int[] nums, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = randomArray(10, 10);
        printArray(nums);
        System.out.println("The original size: " + nums.length);
        nums = resize(nums, 20);
        printArray(nums);
        System.out.println("After resizing: " + nums.length);
    }
}
