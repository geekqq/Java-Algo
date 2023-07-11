package Day257;

import static Day256.PrintArray.printArray;

public class IsEvenInteger {

    public static boolean isEven(int n) {
        if (n <= 0) return false;
        return ((n & 1) == 0);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            if (isEven(i)) {
                System.out.print(i + " ");
            }
        }
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        nums = removeEvenFromArray(nums);
        printArray(nums);
        int[] arr = {3,2,4,7,20, 6,5};
        printArray(removeEvenFromArray(arr));
    }

    public static int[] removeEvenFromArray(int[] nums) {
        int oddCount = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!isEven(nums[i])) {
                oddCount++;
            }
        }
        int[] newArr = new int[oddCount];
        for (int i = 0; i < nums.length; i++) {
            if (!isEven(nums[i])) {
                newArr[index++] = nums[i];
            }
        }
        return newArr;
    }

}
