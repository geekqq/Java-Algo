package Day86;

public class MergeSort {
    public static void main(String[] args) {

    }
    public static void merge(int[] nums, int l, int m, int r) {
        int leftLen = m - l + 1;
        int rightLen = r - m;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = nums[i + l];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = nums[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < leftLen && j < rightLen) {
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
        while (i < leftLen) {
            nums[k++] = leftArr[i++];
        }
        while (j < rightLen) {
            nums[k++] = rightArr[j++];
        }
    }
}
