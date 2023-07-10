package Day256;

import static Day256.RandomArray.generateRandomArrayWithNoDuplicates;

public class PrintArray {

    public static void printArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= 5*n; i++) {
            System.out.print("-");
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.format("| %2s ", i);
        }
        System.out.println("|");
        for (int i = 0; i <= 5*n; i++) {
            System.out.print("-");
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.format("| %2s ", nums[i]);
        }
        System.out.println("|");
        for (int i = 0; i <= 5*n; i++) {
            System.out.print("-");
        }
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArrayWithNoDuplicates(6, 2, 15);
        printArray(nums);
    }
}
