package Day214;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static List<List<Integer>> combinationSumIII(int k, int n) {
        // candidates are 1 to 9
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k > n) return res;
        List<Integer> list = new ArrayList<>();
        getRes(n, k, res, list, 1);
        return res;
    }

    private static void getRes(int n, int k, List<List<Integer>> res, List<Integer> list, int index) {
        if (n < 0 || list.size() > k) return;
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            getRes(n - i, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSumIII(3, 7));
        System.out.println(combinationSumIII(3,9));
        System.out.println(combinationSumIII(4,1));
    }
}
