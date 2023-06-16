package Day243;

import java.util.Arrays;
import java.util.Scanner;

public class NegSumArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] subArray = Arrays.copyOfRange(arr, i, j + 1);
                if (arraySum(subArray) < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static int arraySum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
