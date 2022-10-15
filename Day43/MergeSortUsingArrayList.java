package Day43;

import java.util.ArrayList;

public class MergeSortUsingArrayList {
    public ArrayList<Integer> mergeSort2(ArrayList<Integer> array) {

        if (array == null || array.size() <= 1) {
            return array;
        }

        return mergeSort2(array, 0, array.size() - 1);
    }

    private ArrayList<Integer> mergeSort2(ArrayList<Integer> array, int left, int right) {
        if (left == right) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(array.get(left));
            return result;
        }

        int mid = left + (right - left) >> 2;
        ArrayList<Integer> leftResult = mergeSort2(array, left, mid);
        ArrayList<Integer> rightResult = mergeSort2(array, mid + 1, right);
        return merge2(leftResult, rightResult);
    }

    private ArrayList<Integer> merge2(ArrayList<Integer> leftResult, ArrayList<Integer> rightResult) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftI = 0;
        int rightI = 0;

        while (leftI < leftResult.size() && rightI < rightResult.size()) {
            if (leftResult.get(leftI) < rightResult.get(rightI)) {
                result.add(leftResult.get(leftI++));
            } else {
                result.add(rightResult.get(rightI++));
            }
        }
        //add remaining elements if any
        while (leftI < leftResult.size()) {
            result.add(leftResult.get(leftI++));
        }
        while (rightI < rightResult.size()) {
            result.add(rightResult.get(rightI++));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,0,-5,8,4,7};

    }
}
