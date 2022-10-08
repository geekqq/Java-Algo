package Day37;

import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] array = {2,5,-2,6,-3,8,0,-7,-9,4};
        //Arrays.sort(array);
        //insert sorting

        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }


        System.out.println("排序后的数组为：" + Arrays.toString(array));
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素2在第" + index + "的位置");
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
