package Day216;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combination(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k > n) return res;
        getRes(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private static void getRes(int n, int k, int index, List<Integer> list, List<List<Integer>> res) {
        if (list.size() >= k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            getRes(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combination(4,2));
    }
}
