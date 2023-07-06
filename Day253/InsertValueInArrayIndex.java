package Day253;

import java.util.Arrays;

public class InsertValueInArrayIndex {

    public static int[] insertValueInArray(int[] nums, int index, int value) {
        int[] newArr = new int[nums.length + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            if (i < index) {
                newArr[i] = nums[i];
            } else if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = nums[i - 1];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        System.out.println(Arrays.toString(insertValueInArray(arr, 3,4)));
    }
}
