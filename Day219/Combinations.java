package Day219;

import OODAdv.A;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
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

    //total 20 combinations: n! / (k! * (n-k)!)
    public static void main(String[] args) {
        System.out.println(combine(6,3));
    }


}
