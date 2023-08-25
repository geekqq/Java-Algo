package Day280;

public class RemoveDuplicatesElementArray {

    public static int removeDuplicatedElement(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int i = 1;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[j - 1]) {
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }
}
