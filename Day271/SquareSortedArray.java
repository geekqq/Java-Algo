package Day271;

import java.util.Arrays;

import static Day256.PrintArray.printArray;
import static Day271.GenerateArrayWithoutDuplicates.generateArrayWithoutDuplicates;

public class SquareSortedArray {

    public static int[] squareSortedArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int[] newArr = new int[arr.length];

        for (int k = newArr.length - 1; k >= 0; k--)
        {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                newArr[k] = arr[i] * arr[i];
                i++;
            } else {
                newArr[k] = arr[j] * arr[j];
                j--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = generateArrayWithoutDuplicates(10, -10, 25);
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        int[] newArr = squareSortedArray(arr);
        printArray(newArr);
    }
}
